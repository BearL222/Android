package com.lizhecheng.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    public static int[][] result;

    public static boolean sudoku(int tmp[][], int x, int y) {
        if (tmp[x][y] == 0) {
            int p = x / 3;
            int q = y / 3;
            int j;
            for (j = 1; j <= 9; ++j) {
                int flag = 0;
                for (int k = 0; k < 9; ++k) {
                    if (tmp[x][k] == j) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) continue;
                for (int k = 0; k < 9; ++k) {
                    if (tmp[k][y] == j) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) continue;
                int m_max = p * 3 + 3;
                int n_max = q * 3 + 3;
                for (int m = p * 3; m < m_max; ++m) {
                    for (int n = q * 3; n < n_max; ++n) {
                        if (m == x && n == y) break;
                        if (tmp[m][n] == j) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1) break;
                }
                if (flag == 1) continue;
                int[][] tmp2 = new int[9][9];
                for (int s = 0; s < 9; ++s) {
                    for (int t = 0; t < 9; ++t) {
                        tmp2[s][t] = tmp[s][t];
                    }
                }
                tmp2[x][y] = j;
                if (x == 8 && y == 8) {
                    result = tmp;
                    result[8][8]=j;
                    return true;
                } else if (y != 8) {
                    if (sudoku(tmp2, x, y + 1)) {
                        return true;
                    }
                } else {
                    if (sudoku(tmp2, x + 1, 0)) {
                        return true;
                    }
                }
            }
        } else {
            if (x == 8 && y == 8) {
                result = tmp;
                return true;
            } else if (y != 8) {
                if (sudoku(tmp, x, y + 1)) {
                    return true;
                }
            } else {
                if (sudoku(tmp, x + 1, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calc_button = (Button) findViewById(R.id.calc_button);
        calc_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int[][] board = new int[9][9];
                int number = 0;

                EditText line0 = (EditText) findViewById(R.id.editText0);
                number = Integer.parseInt(line0.getText().toString());
                for (int i = 8; i >= 0; --i) {
                    board[0][i] = number % 10;
                    number /= 10;
                }

                EditText line1 = (EditText) findViewById(R.id.editText1);
                number = Integer.parseInt(line1.getText().toString());
                for (int i = 8; i >= 0; --i) {
                    board[1][i] = number % 10;
                    number /= 10;
                }

                EditText line2 = (EditText) findViewById(R.id.editText2);
                number = Integer.parseInt(line2.getText().toString());
                for (int i = 8; i >= 0; --i) {
                    board[2][i] = number % 10;
                    number /= 10;
                }

                EditText line3 = (EditText) findViewById(R.id.editText3);
                number = Integer.parseInt(line3.getText().toString());
                for (int i = 8; i >= 0; --i) {
                    board[3][i] = number % 10;
                    number /= 10;
                }

                EditText line4 = (EditText) findViewById(R.id.editText4);
                number = Integer.parseInt(line4.getText().toString());
                for (int i = 8; i >= 0; --i) {
                    board[4][i] = number % 10;
                    number /= 10;
                }

                EditText line5 = (EditText) findViewById(R.id.editText5);
                number = Integer.parseInt(line5.getText().toString());
                for (int i = 8; i >= 0; --i) {
                    board[5][i] = number % 10;
                    number /= 10;
                }

                EditText line6 = (EditText) findViewById(R.id.editText6);
                number = Integer.parseInt(line6.getText().toString());
                for (int i = 8; i >= 0; --i) {
                    board[6][i] = number % 10;
                    number /= 10;
                }

                EditText line7 = (EditText) findViewById(R.id.editText7);
                number = Integer.parseInt(line7.getText().toString());
                for (int i = 8; i >= 0; --i) {
                    board[7][i] = number % 10;
                    number /= 10;
                }

                EditText line8 = (EditText) findViewById(R.id.editText8);
                number = Integer.parseInt(line8.getText().toString());
                for (int i = 8; i >= 0; --i) {
                    board[8][i] = number % 10;
                    number /= 10;
                }
                if (sudoku(board, 0, 0)) {
                    String toDisplay;
                    toDisplay = "";
                    for (int i = 0; i < 9; ++i) {
                        toDisplay = toDisplay + result[0][i];
                    }
                    line0.setText(toDisplay);

                    toDisplay = "";
                    for (int i = 0; i < 9; ++i) {
                        toDisplay = toDisplay + result[1][i];
                    }
                    line1.setText(toDisplay);

                    toDisplay = "";
                    for (int i = 0; i < 9; ++i) {
                        toDisplay = toDisplay + result[2][i];
                    }
                    line2.setText(toDisplay);

                    toDisplay = "";
                    for (int i = 0; i < 9; ++i) {
                        toDisplay = toDisplay + result[3][i];
                    }
                    line3.setText(toDisplay);

                    toDisplay = "";
                    for (int i = 0; i < 9; ++i) {
                        toDisplay = toDisplay + result[4][i];
                    }
                    line4.setText(toDisplay);

                    toDisplay = "";
                    for (int i = 0; i < 9; ++i) {
                        toDisplay = toDisplay + result[5][i];
                    }
                    line5.setText(toDisplay);

                    toDisplay = "";
                    for (int i = 0; i < 9; ++i) {
                        toDisplay = toDisplay + result[6][i];
                    }
                    line6.setText(toDisplay);

                    toDisplay = "";
                    for (int i = 0; i < 9; ++i) {
                        toDisplay = toDisplay + result[7][i];
                    }
                    line7.setText(toDisplay);

                    toDisplay = "";
                    for (int i = 0; i < 9; ++i) {
                        toDisplay = toDisplay + result[8][i];
                    }
                    line8.setText(toDisplay);
                }
            }
        });
        Button clear_button = (Button) findViewById(R.id.clear_button);
        clear_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText line0 = (EditText) findViewById(R.id.editText0);
                EditText line1 = (EditText) findViewById(R.id.editText1);
                EditText line2 = (EditText) findViewById(R.id.editText2);
                EditText line3 = (EditText) findViewById(R.id.editText3);
                EditText line4 = (EditText) findViewById(R.id.editText4);
                EditText line5 = (EditText) findViewById(R.id.editText5);
                EditText line6 = (EditText) findViewById(R.id.editText6);
                EditText line7 = (EditText) findViewById(R.id.editText7);
                EditText line8 = (EditText) findViewById(R.id.editText8);
                line0.setText("000000000");
                line1.setText("000000000");
                line2.setText("000000000");
                line3.setText("000000000");
                line4.setText("000000000");
                line5.setText("000000000");
                line6.setText("000000000");
                line7.setText("000000000");
                line8.setText("000000000");
            }
        });
    }
}
