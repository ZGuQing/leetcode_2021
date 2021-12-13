package com.leetcode.december;

/**
 * @Author zhuguoqing
 * @Description 有效的井字游戏
 * @Date 2021/12/8 8:06 下午
 * @Version 1.0
 */
public class lc794 {
    public boolean validTicTacToe(String[] board) {
        //1、X必须比O多1个或者相同，否则false；
        //2、X和O不能同时都是赢家，否则false；
        //3、X赢的时候必须比O多1个，否则false；
        //4、O赢得时候个数与X相同，否则false；
        int countX = 0, countO = 0;
        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'X') {
                    countX++;
                } else if (s.charAt(j) == 'O') {
                    countO++;
                }
            }
        }
        if (countO != countX && countO != countX - 1) {
            return false;
        }
        if (win(board, 'X') && countX != countO + 1) {
            return false;
        }
        if (win(board, 'O') && countX != countO) {
            return false;
        }
        return true;
    }

    private boolean win(String[] board, char p) {
        for (int i = 0; i < 3; i++) {
            //行相同
            if (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2)) {
                return true;
            }
            //列相同
            if (p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) {
                return true;
            }
        }
        //两个对角线
        if (p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) {
            return true;
        }
        if (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)) {
            return true;
        }
        return false;
    }

}
