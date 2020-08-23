# Runtime: 240 ms
# Memory Usage: 16.5 MB

# dp 사용
class NumMatrix:
    def __init__(self, matrix: List[List[int]]):
        self.matrix = matrix
        self.row = len(matrix)
        if self.row != 0:
            self.col = len(matrix[0])
            self.dp = [[0]*(self.col + 1) for _ in range(self.row)]
            # 각 row 마다 앞에서부터 sum 을 dp에 저장
            for y in range(0, self.row):
                for x in range(0, self.col):
                    self.dp[y][x+1] = self.dp[y][x] + matrix[y][x]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        sum = 0
    #     구해야하는 범위를 dp에 있는 sum의 차이를 통해 구한다
        for y in range(row1, row2 + 1):
               sum += self.dp[y][col2+1] - self.dp[y][col1]
        return sum