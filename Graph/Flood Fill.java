/*Ankit has found his new passion for photography. He has clicked some really good photos but in one of his images, he doesn’t like the color of a particular region. So, he decides to change the color of that region. Can you help him with this task? The image is represented in the form of a 2D array of size M * N. Each pixel in the image is a positive integer. Ankit has given you the coordinates (row and column) of a certain pixel and the new color value. You need to replace the color of the given pixel and all adjacent same-colored pixels with the new color.

Note:

Two pixels are adjacent if they are connected to each other in any of the four directions: up, down, left, or right. Diagonal pixels are not considered adjacent.*/

import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] image = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                image[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int newColor = sc.nextInt();
        int[][] ans = Solution.floodFill(image, x, y, newColor);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(j == m-1) {
                    System.out.print(ans[i][j] + "\n");
                }
                else {
                    System.out.print(ans[i][j] + " ");
                }
            }
        }
    }
}

class Solution
{
	static void dfs(int[][]image, int x, int y, int color, int prevcolor){
		if(x<0 || y<0 || x>=image.length || y>=image[0].length || image[x][y]==color || image[x][y]!= prevcolor){
			return ;
		}

		//make it colorful
		image[x][y]=color;

		//go to 4-direction
		dfs(image, x+1, y, color, prevcolor);
		dfs(image, x, y-1, color, prevcolor);
		dfs(image, x-1, y, color, prevcolor);
		dfs(image, x, y+1, color, prevcolor);
	}

    static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {

        if(image[x][y]==newColor)return image;

		dfs(image, x, y, newColor, image[x][y]);

		return image;
    }
}
