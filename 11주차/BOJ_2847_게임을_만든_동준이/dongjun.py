import pytest


class P2847():
    def set_input(self, n, scores):
        self.length = n
        self.scores = scores

    def solve(self):
        ret = 0

        for now_level_idx in range(self.length - 2, -1, -1):
            ret += self._reduce_score(now_level_idx)

        return ret

    def _reduce_score(self, idx):
        if idx + 1 >= len(self.scores):
            return 0
        if self.scores[idx] < self.scores[idx+1]:
            return 0

        ret = self.scores[idx] - self.scores[idx+1] + 1

        self.scores[idx] = self.scores[idx+1] - 1

        return ret


def test_2847():
    N = 4
    scores = [5, 3, 7, 5]

    problem = P2847()

    problem.set_input(N, scores)

    answer = 6

    assert answer == problem.solve()

    problem.set_input(4, [1, 2, 3, 4])

    assert 0 == problem.solve()


def main():
    n = int(input())
    scores = [int(input()) for _ in range(n)]

    problem = P2847()
    problem.set_input(n, scores)

    print(problem.solve())


if __name__ == '__main__':
    main()
