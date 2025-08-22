package com.pbear.chess.core.rule;

public interface MoveRule extends ChessRule {
  MoveRule INSTANCE = new MoveRule() {};

  default long n(final long position) {
    return position << 8;
  }

  default long s(final long position) {
    return position >>> 8;
  }

  default long e(final long position) {
    return (position & ~Mask.FILE_H) << 1;
  }

  default long w(final long position) {
    return (position & ~Mask.FILE_A) >>> 1;
  }

  default long ne(final long position) {
    return (position & ~Mask.FILE_H) << 9;
  }

  default long nw(final long position) {
    return (position & ~Mask.FILE_A) << 7;
  }

  default long se(final long position) {
    return (position & ~Mask.FILE_H) >>> 7;
  }

  default long sw(final long position) {
    return (position & ~Mask.FILE_A) >>> 9;
  }

  default long nne(final long position) {
    return (position & ~Mask.FILE_H) << 17;
  }

  default long nnw(final long position) {
    return (position & ~Mask.FILE_A) << 15;
  }

  default long ene(final long position) {
    return (position & ~Mask.FILE_GH) << 10;
  }

  default long ese(final long position) {
    return (position & ~Mask.FILE_GH) >>> 6;
  }

  default long sse(final long position) {
    return (position & ~Mask.FILE_H) >>> 15;
  }

  default long ssw(final long position) {
    return (position & ~Mask.FILE_A) >>> 17;
  }

  default long wnw(final long position) {
    return (position & ~Mask.FILE_AB) << 6;
  }

  default long wsw(final long position) {
    return (position & ~Mask.FILE_AB) >>> 10;
  }

  default long nn(final long position) {
    return position << 16;
  }

  default long ss(final long position) {
    return position >>> 16;
  }

  default long fileRay(final long position) {
    return ((position & Mask.FILE_A) != 0 ? Mask.FILE_A : 0)
        | ((position & Mask.FILE_B) != 0 ? Mask.FILE_B : 0)
        | ((position & Mask.FILE_C) != 0 ? Mask.FILE_C : 0)
        | ((position & Mask.FILE_D) != 0 ? Mask.FILE_D : 0)
        | ((position & Mask.FILE_E) != 0 ? Mask.FILE_E : 0)
        | ((position & Mask.FILE_F) != 0 ? Mask.FILE_F : 0)
        | ((position & Mask.FILE_G) != 0 ? Mask.FILE_G : 0)
        | ((position & Mask.FILE_H) != 0 ? Mask.FILE_H : 0);
  }

  default long rankRay(final long position) {
    return ((position & Mask.RANK_1) != 0 ? Mask.RANK_1 : 0)
        | ((position & Mask.RANK_2) != 0 ? Mask.RANK_2 : 0)
        | ((position & Mask.RANK_3) != 0 ? Mask.RANK_3 : 0)
        | ((position & Mask.RANK_4) != 0 ? Mask.RANK_4 : 0)
        | ((position & Mask.RANK_5) != 0 ? Mask.RANK_5 : 0)
        | ((position & Mask.RANK_6) != 0 ? Mask.RANK_6 : 0)
        | ((position & Mask.RANK_7) != 0 ? Mask.RANK_7 : 0)
        | ((position & Mask.RANK_8) != 0 ? Mask.RANK_8 : 0);
  }

  default long mainDiagonalRay(final long position) {
    return ((position & Mask.DIAGONAL_MAIN_1) != 0 ? Mask.DIAGONAL_MAIN_1 : 0)
        | ((position & Mask.DIAGONAL_MAIN_2) != 0 ? Mask.DIAGONAL_MAIN_2 : 0)
        | ((position & Mask.DIAGONAL_MAIN_3) != 0 ? Mask.DIAGONAL_MAIN_3 : 0)
        | ((position & Mask.DIAGONAL_MAIN_4) != 0 ? Mask.DIAGONAL_MAIN_4 : 0)
        | ((position & Mask.DIAGONAL_MAIN_5) != 0 ? Mask.DIAGONAL_MAIN_5 : 0)
        | ((position & Mask.DIAGONAL_MAIN_6) != 0 ? Mask.DIAGONAL_MAIN_6 : 0)
        | ((position & Mask.DIAGONAL_MAIN_7) != 0 ? Mask.DIAGONAL_MAIN_7 : 0)
        | ((position & Mask.DIAGONAL_MAIN_8) != 0 ? Mask.DIAGONAL_MAIN_8 : 0)
        | ((position & Mask.DIAGONAL_MAIN_9) != 0 ? Mask.DIAGONAL_MAIN_9 : 0)
        | ((position & Mask.DIAGONAL_MAIN_10) != 0 ? Mask.DIAGONAL_MAIN_10 : 0)
        | ((position & Mask.DIAGONAL_MAIN_11) != 0 ? Mask.DIAGONAL_MAIN_11 : 0)
        | ((position & Mask.DIAGONAL_MAIN_12) != 0 ? Mask.DIAGONAL_MAIN_12 : 0)
        | ((position & Mask.DIAGONAL_MAIN_13) != 0 ? Mask.DIAGONAL_MAIN_13 : 0);
  }

  default long antiDiagonalRay(final long position) {
    return ((position & Mask.DIAGONAL_ANTI_1) != 0 ? Mask.DIAGONAL_ANTI_1 : 0)
        | ((position & Mask.DIAGONAL_ANTI_2) != 0 ? Mask.DIAGONAL_ANTI_2 : 0)
        | ((position & Mask.DIAGONAL_ANTI_3) != 0 ? Mask.DIAGONAL_ANTI_3 : 0)
        | ((position & Mask.DIAGONAL_ANTI_4) != 0 ? Mask.DIAGONAL_ANTI_4 : 0)
        | ((position & Mask.DIAGONAL_ANTI_5) != 0 ? Mask.DIAGONAL_ANTI_5 : 0)
        | ((position & Mask.DIAGONAL_ANTI_6) != 0 ? Mask.DIAGONAL_ANTI_6 : 0)
        | ((position & Mask.DIAGONAL_ANTI_7) != 0 ? Mask.DIAGONAL_ANTI_7 : 0)
        | ((position & Mask.DIAGONAL_ANTI_8) != 0 ? Mask.DIAGONAL_ANTI_8 : 0)
        | ((position & Mask.DIAGONAL_ANTI_9) != 0 ? Mask.DIAGONAL_ANTI_9 : 0)
        | ((position & Mask.DIAGONAL_ANTI_10) != 0 ? Mask.DIAGONAL_ANTI_10 : 0)
        | ((position & Mask.DIAGONAL_ANTI_11) != 0 ? Mask.DIAGONAL_ANTI_11 : 0)
        | ((position & Mask.DIAGONAL_ANTI_12) != 0 ? Mask.DIAGONAL_ANTI_12 : 0)
        | ((position & Mask.DIAGONAL_ANTI_13) != 0 ? Mask.DIAGONAL_ANTI_13 : 0);
  }
}
