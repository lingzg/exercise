package com.lingzg.jobbole;

/**
 * 判断一个正整数是否2的乘方，要求性能最优
 * 使用位运算
 * form ：http://blog.jobbole.com/107689/
 * @author lingzg
 *
 */
public class PowerOf2 {

	public static void main(String[] args) {
//		long s = System.nanoTime();
////		boolean f = isPowerOf2(1024*1024*1024+1);
//		long m = System.nanoTime();
//		boolean f2 = isPowerOfTwo(1024*1024*1024+1);
////		int n = countOf1(2119724597);
//		long e = System.nanoTime();
////		System.out.println(m-s);
//		System.out.println(e-m);
////		System.out.println(n);
////		System.out.println(f);
//		System.out.println(f2);
		System.out.println(countOf1(1001101));
	}

	
	/**
	 * 因为2的乘方都符合一个规律，即 N&N-1 等于 0，所以直接用这个规律判断即可。该算法时间复杂度是O（1）。
	 * @param n
	 * @return
	 */
	public static boolean isPowerOf2(int n){
		if(n<=0){
			throw new RuntimeException("invalid argument");
		}
		return (n & n-1)==0;
	}
	
	/**
	 * 创建一个中间变量Temp，初始值是1。然后进入一个循环，循环中每次让Temp和目标整数比较，如果相等，则说明目标整数是2的乘方；
	 * 如果不相等，则让Temp增大一倍，继续循环比较。
	 * 当Temp大于目标整数时，说明目标整数不是2的乘方。如果目标整数的大小是N，则此方法的时间复杂度是O（LogN）。
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwo(int n){
		if(n<=0){
			throw new RuntimeException("invalid argument");
		}
		int temp =1;
		while(temp<=n){
			if(temp==n){
				return true;
			}
			temp = temp<<1;
		}
		return false;
	}
	
	/**
	 * 实现一个方法，求出一个正整数转换成二进制后的数字“1”的个数。要求性能尽可能高。
	 * @param n
	 * @return
	 */
	public static int countOf1(int n){
		if(n<=0){
			throw new RuntimeException("invalid argument");
		}
		int count = 0;
		System.out.println(Integer.toBinaryString(n));
		while(n!=0){
			n &= n-1;
			System.out.println(Integer.toBinaryString(n));
			count++;
		}
		return count;
	}
}
