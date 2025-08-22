package com.pbear.chess.core.rule;

public class Mask {
  public static final long FILE_A = 0x101010101010101L;
  public static final long FILE_B = 0x202020202020202L;
  public static final long FILE_C = 0x404040404040404L;
  public static final long FILE_D = 0x808080808080808L;
  public static final long FILE_E = 0x1010101010101010L;
  public static final long FILE_F = 0x2020202020202020L;
  public static final long FILE_G = 0x4040404040404040L;
  public static final long FILE_H = 0x8080808080808080L;

  public static final long RANK_1 = 0x00000000000000FFL;
  public static final long RANK_2 = 0x000000000000FF00L;
  public static final long RANK_3 = 0x0000000000FF0000L;
  public static final long RANK_4 = 0x00000000FF000000L;
  public static final long RANK_5 = 0x000000FF00000000L;
  public static final long RANK_6 = 0x0000FF0000000000L;
  public static final long RANK_7 = 0x00FF000000000000L;
  public static final long RANK_8 = 0xFF00000000000000L;

  public static final long FILE_AB = 0x303030303030303L;
  public static final long FILE_GH = 0xC0C0C0C0C0C0C0C0L;

  // A1-H8
  public static final long DIAGONAL_MAIN_1 = 0x8040L;
  public static final long DIAGONAL_MAIN_2 = 0x804020L;
  public static final long DIAGONAL_MAIN_3 = 0x80402010L;
  public static final long DIAGONAL_MAIN_4 = 0x8040201008L;
  public static final long DIAGONAL_MAIN_5 = 0x804020100804L;
  public static final long DIAGONAL_MAIN_6 = 0x80402010080402L;
  public static final long DIAGONAL_MAIN_7 = 0x8040201008040201L;
  public static final long DIAGONAL_MAIN_8 = 0x4020100804020100L;
  public static final long DIAGONAL_MAIN_9 = 0x2010080402010000L;
  public static final long DIAGONAL_MAIN_10 = 0x1008040201000000L;
  public static final long DIAGONAL_MAIN_11 = 0x804020100000000L;
  public static final long DIAGONAL_MAIN_12 = 0x402010000000000L;
  public static final long DIAGONAL_MAIN_13 = 0x201000000000000L;

  // A8-H1
  public static final long DIAGONAL_ANTI_1 = 0x102L;
  public static final long DIAGONAL_ANTI_2 = 0x10204L;
  public static final long DIAGONAL_ANTI_3 = 0x1020408L;
  public static final long DIAGONAL_ANTI_4 = 0x102040810L;
  public static final long DIAGONAL_ANTI_5 = 0x10204081020L;
  public static final long DIAGONAL_ANTI_6 = 0x1020408102040L;
  public static final long DIAGONAL_ANTI_7 = 0x102040810204080L;
  public static final long DIAGONAL_ANTI_8 = 0x204081020408000L;
  public static final long DIAGONAL_ANTI_9 = 0x408102040800000L;
  public static final long DIAGONAL_ANTI_10 = 0x810204080000000L;
  public static final long DIAGONAL_ANTI_11 = 0x1020408000000000L;
  public static final long DIAGONAL_ANTI_12 = 0x2040800000000000L;
  public static final long DIAGONAL_ANTI_13 = 0x4080000000000000L;

}
