package test.sort;

import java.util.Arrays;

public class MpSort {

	//Ã°ÅÝ
	public static void main(String[] args) {
         int [] arr = {1,2,4,5,3,67,2,566,33,2,68,86,3,5,7,3,24,5,646,46,46,6,3,5,6,75,76,86,8,6,57,7,7,4,4,6
        		 ,64,6,46,46,3,2,4,7,8,97,9,9,6,43,2,2222,4,542,6,7,7,332,2,24,6,8,0,6,64,4,4,55,22,2,5,25};
         int a = 0;
        for (int i = arr.length -1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				a++;
				if (arr[j] > arr[j+1]) {
					int tem = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tem;
				}
			}
		}
		/*for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				a++;
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}*/
         System.out.println(Arrays.toString(arr));
         System.out.println("³¤¶È£º"+arr.length);
         System.out.println("aa:"+a);
	}

}
