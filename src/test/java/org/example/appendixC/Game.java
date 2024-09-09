package org.example.appendixC;

public class Game {
    private GameNumGen gameNumGen;

    public Game(GameNumGen gameNumGen) {
        this.gameNumGen = gameNumGen;
    }

    public void init(GameLevel level) {
        this.gameNumGen.generate(level);
    }
}
