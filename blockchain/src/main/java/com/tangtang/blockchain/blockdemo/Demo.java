package com.tangtang.blockchain.blockdemo;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * @author tangwenbo
 * @date 2018/2/23
 * @since JDK1.8
 */
public class Demo {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList:
        blockchain.add(new Block("Hi im the first block", "0"));
        blockchain.add(new Block("Yo im the second block", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("Hey im the third block", blockchain.get(blockchain.size() - 1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
}
