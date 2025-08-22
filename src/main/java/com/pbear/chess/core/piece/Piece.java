package com.pbear.chess.core.piece;

import com.pbear.chess.core.GameContext;

public interface Piece {
  Color getColor();
  long getOccupancy();
  void setOccupancy(final long occupancy);
  long computeControlled(final GameContext context);

  default void move(final long move) {
    this.setOccupancy(this.getOccupancy() ^ move);
  }

  enum Color {
    WHITE, BLACK
  }
}
