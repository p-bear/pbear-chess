package com.pbear.chess.core.piece;

import com.pbear.chess.core.GameContext;
import com.pbear.chess.core.rule.MoveRule;
import lombok.Getter;
import lombok.Setter;

public class King implements Piece {
  @Getter
  private final Piece.Color color;
  @Getter
  @Setter
  private long occupancy;
  private long castlingMask;

  public King(final Color color) {
    this.color = color;
    this.occupancy = switch (color) {
      case WHITE -> 0b10000L;
      case BLACK -> 0x1000000000000000L;
    };
    this.castlingMask = switch (color) {
      case WHITE -> 0b1000100L;
      case BLACK -> 0x4400000000000000L;
    };
  }

  @Override
  public long computeControlled(final GameContext context) {
    long controlledMask = switch (color) {
      case WHITE -> context.getBlackControlled(false);
      case BLACK -> context.getWhiteControlled(false);
    };

    return (this.aroundMove() ^ controlledMask) | this.computeCastlingMask(controlledMask);
  }

  public void disableACastling() {
    switch (color) {
      case WHITE -> castlingMask = castlingMask ^ 0b100L;
      case BLACK -> castlingMask = castlingMask ^ 0x400000000000000L;
    }
  }

  public void disableHCastling() {
    switch (color) {
      case WHITE -> castlingMask = castlingMask ^ 0b1000000L;
      case BLACK -> castlingMask = castlingMask ^ 0x4000000000000000L;
    }
  }

  private long aroundMove() {
    return MoveRule.INSTANCE.n(occupancy)
        | MoveRule.INSTANCE.ne(occupancy)
        | MoveRule.INSTANCE.e(occupancy)
        | MoveRule.INSTANCE.se(occupancy)
        | MoveRule.INSTANCE.s(occupancy)
        | MoveRule.INSTANCE.sw(occupancy)
        | MoveRule.INSTANCE.w(occupancy)
        | MoveRule.INSTANCE.nw(occupancy);
  }

  private long computeCastlingMask(final long controlledMask) {
    return switch (color) {
      case WHITE -> {
        long temp = castlingMask;
        if ((controlledMask & 0b11110L) != 0) {
          temp = castlingMask ^ 0b100L;
        }
        if ((controlledMask & 0b1110000L) != 0) {
          temp = castlingMask ^ 0b1000000L;
        }
        yield temp;
      }
      case BLACK -> {
        long temp = castlingMask;
        if ((controlledMask & 0x1E00000000000000L) != 0) {
          temp = castlingMask ^ 0x400000000000000L;
        }
        if ((controlledMask & 0x7000000000000000L) != 0) {
          temp = castlingMask ^ 0x4000000000000000L;
        }
        yield temp;
      }
    };
  }
}
