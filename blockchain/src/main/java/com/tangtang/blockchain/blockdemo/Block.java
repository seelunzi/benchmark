package com.tangtang.blockchain.blockdemo;


public class Block {

    public String hash;
    public String previousHash;
    /***
     * our data will be a simple message.
     * */
    private String data;
    /***
     *as number of milliseconds since 1/1/1970.
     * */
    private long timeStamp;
    private int nonce;

    /**
     * Block Constructor.
     */
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
        //Making sure we do this after we set the other values.
        this.hash = calculateHash();
    }

    /**
     * Calculate new hash based on blocks contents
     */
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
        return calculatedhash;
    }

    /**
     * Increases nonce value until hash target is reached.
     */
    public void mineBlock(int difficulty) {
        //Create a string with difficulty * "0"
        String target = StringUtil.getDificultyString(difficulty);
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block已挖到!!! : " + hash);
    }

}