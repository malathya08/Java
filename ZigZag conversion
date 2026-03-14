#include <stdlib.h>
#include <string.h>
char* convert(char* s, int numRows) {
    if (numRows == 1 || s == NULL) {
        return strdup(s);
    }
    int len = strlen(s);
    char* result = (char*)malloc(len + 1);
    int index = 0;
    for (int row = 0; row < numRows; ++row) {
        int step1 = 2 * (numRows - row - 1);
        int step2 = 2 * row;
        int pos = row;
        int toggle = 0;
        while (pos < len) {
            result[index++] = s[pos];
            if (row == 0 || row == numRows - 1) {
                pos += (row == 0) ? step1 : step2;
            } else {
                if (toggle % 2 == 0)
                    pos += step1;
                else
                    pos += step2;
                toggle++;
            }
        }
    }
    result[index] = '\0';
    return result;
}
