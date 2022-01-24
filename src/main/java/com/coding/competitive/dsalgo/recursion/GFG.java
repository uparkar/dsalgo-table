package com.coding.competitive.dsalgo.recursion;

public class GFG
{
    static int fun(int count)
    {
        System.out.println(count);
        if(count < 3)
        {
            fun(fun(fun(++count)));
        }
        return count;
    }

    public static void main(String[] args)
    {
        fun(1);
    }
}

