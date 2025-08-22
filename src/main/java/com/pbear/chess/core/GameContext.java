package com.pbear.chess.core;

import com.pbear.chess.core.piece.King;
import com.pbear.chess.core.piece.Piece;
import lombok.Getter;

@Getter
public class GameContext {
  private final King whiteKing = new King(Piece.Color.WHITE);
  private final King blackKing = new King(Piece.Color.BLACK);

  public long getWhiteOccupancy() {
    return whiteKing.getOccupancy();
  }

  public long getBlackOccupancy() {
    return blackKing.getOccupancy();
  }

  public long getWhiteControlled(final boolean includeKing) {
    return includeKing ?
        whiteKing.computeControlled(this)
        : 0L;
  }

  public long getBlackControlled(final boolean includeKing) {
    return includeKing ?
        blackKing.computeControlled(this)
        : 0L;
  }
}
