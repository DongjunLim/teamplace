#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
#include <queue>
 
using namespace std;
 
 int n;
 int apart = 1;
 int map[25][25]={0,};
 bool visited[25][25];

 int dirX[4] = {0,  0, 1, -1};
 int dirY[4] = {1, -1, 0, 0};

bool isBoundary(int x, int y){
     return ((x >= 0 && x < n) && (y >= 0 && y < n));
 }

 void bfs(int x, int y){
     queue<pair<int, int>> q;
     q.push(make_pair(x, y));
     map[x][y] = apart;
     visited[x][y] = true;

     while(!q.empty()){
         pair<int, int> p = q.front();
         q.pop();

         for(int i = 0; i < 4; i++){
             int dx = p.first + dirX[i];
             int dy = p.second + dirY[i];

             if(!visited[dx][dy] && isBoundary(dx, dy) && map[dx][dy] != 0){
                 visited[dx][dy] = true;
                 q.push(make_pair(dx, dy));
                 map[dx][dy] = apart;
             }
         }
     }
 }

 

int main(void){
    string str;
    
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> str;
        for(int j=0; j<str.size(); j++) 
            map[i][j] = str[j] - 48;
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(!visited[i][j] && map[i][j] != 0){
                bfs(i, j);
                apart += 1;
            }
        }
    } 

    int *ans = new int[apart - 1]{0, };
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    ans[map[i][j] - 1] += 1;
                }
        }
    }

    sort(ans, ans + (apart-1));
    cout << apart - 1 << endl;
    for(int i=0; i < apart - 1; i++){
        cout << ans[i] << endl;
    }

    return 0;
}


