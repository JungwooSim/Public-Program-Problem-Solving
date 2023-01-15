package com.example.leetcode

/*
43. Multiply Strings
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.

 */

fun main() {

  println(multiply("2", "3"))
  println(multiply("123", "456"))
}

fun multiply(num1: String, num2: String): String {

  // 문자열을 숫자로 변환하는 경우에는 거꿀로 치환하여 계산하는게 TIP
  val n1 = num1.reversed()
  val n2 = num2.reversed()
  var arr = arrayOfNulls<Int>(n1.length + n2.length)

  for (i in n1.indices) {
    for (j in n2.indices) {
      var a = (n1[i]-'0')
      var b = (n2[j]-'0')
      var ab = a * b

//      println("i : ${i} / j : ${j} / a : ${a} / b : ${b}")
      arr[i+j] = if (arr[i + j] == null) ab else arr[i+j]!! + ab
    }
//    println(arr.contentToString())
  }

//  println(arr.contentToString())

  var result: String = ""
  for (i in arr.indices) {
    var digit = arr[i]?.rem(10)
    var carry = arr[i]?.div(10)

//    println("digit : ${digit}")
//    println("carry : ${carry}")
//    println("----")

    if (carry !== null && (i+1) < arr.size) {
      var tempSum = arr[i+1]?: 0
      arr[i+1] = carry.plus(tempSum)
    }

    digit?.let {
      result = digit.toString() + result
    }
  }

  var index = 0
  while (index < result.length - 1 && result[index] == '0') {
    index++
  }

//  println("index = $index")


  return result.substring(index)
}

/*
public class Solution {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        int[] d = new int[n1.length()+n2.length()];
        for(int i=0; i < n1.length(); i++){
            for(int j=0; j < n2.length(); j++){
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
            }
        }

        String result = "";
        for(int i=0; i < d.length; i++){
            int digit = d[i]%10;
            int carry = d[i]/10;
            if(i+1 < d.length){
                d[i+1] += carry;
            }
            result = (digit + "") + result;
        }
        int index = 0;
        while(index < result.length() - 1 && result.charAt(index)=='0'){
            index ++;
        }
        return result.substring(index);

    }
}
 */