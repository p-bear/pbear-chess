package com.pbear.chess.core.pieces;

import com.pbear.chess.core.GameContext;
import com.pbear.chess.core.piece.King;
import com.pbear.chess.core.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class KingTest {
  King whiteKing;
  King blackKing;

  @BeforeEach
  void setUp() {
    whiteKing = new King(Piece.Color.WHITE);
    blackKing = new King(Piece.Color.BLACK);
  }

  @Test
  @DisplayName("기본 움직임 테스트 (castling 포함)")
  void testBasicMove(@Mock GameContext gameContextMock) {
    // only King on board
    lenient().when(gameContextMock.getWhiteOccupancy()).thenReturn(whiteKing.getOccupancy());
    lenient().when(gameContextMock.getBlackOccupancy()).thenReturn(blackKing.getOccupancy());
    lenient().when(gameContextMock.getWhiteControlled(any(Boolean.class))).thenReturn(0L);
    lenient().when(gameContextMock.getBlackControlled(any(Boolean.class))).thenReturn(0L);

    // e1
    assertEquals(
        0b11100001101100L,
        whiteKing.computeControlled(gameContextMock));

    // e8
    assertEquals(
        0x6C38000000000000L,
        blackKing.computeControlled(gameContextMock));
  }

  @Test
  @DisplayName("벽막힘 움직임 테스트")
  void testWallMove(@Mock GameContext gameContextMock) {
    // only King on board, no controlled square
    lenient().when(gameContextMock.getWhiteOccupancy()).thenReturn(whiteKing.getOccupancy());
    lenient().when(gameContextMock.getBlackOccupancy()).thenReturn(blackKing.getOccupancy());
    lenient().when(gameContextMock.getWhiteControlled(any(Boolean.class))).thenReturn(0L);
    lenient().when(gameContextMock.getBlackControlled(any(Boolean.class))).thenReturn(0L);

    Map<Long, Long> tc = Map.of(
        0b10000000000000000L, 0b11000000100000001100000000L,
        0b100000000000000000000000L, 0b11000000010000001100000000000000L,
        0b10000L, 0b11100000101000L,
        0b1000000000000000000000000000000000000000000000000000000000000L, 0b10100000111000000000000000000000000000000000000000000000000000L,
        0b10000000L, 0b1100000001000000L,
        0b1L, 0b1100000010L,
        0b1000000000000000000000000000000000000000000000000000000000000000L, 0b100000011000000000000000000000000000000000000000000000000000000L,
        0b100000000000000000000000000000000000000000000000000000000L, 0b1000000011000000000000000000000000000000000000000000000000L
    );

    whiteKing.disableACastling();
    whiteKing.disableHCastling();
    for (Map.Entry<Long, Long> entry : tc.entrySet()) {
      whiteKing.setOccupancy(entry.getKey());
      assertEquals(
          entry.getValue(),
          whiteKing.computeControlled(gameContextMock));
    }
  }
}