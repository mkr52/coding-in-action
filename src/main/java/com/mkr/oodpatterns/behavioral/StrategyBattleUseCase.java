package com.mkr.oodpatterns.behavioral;

public class StrategyBattleUseCase {
    public static void main(String[] args) {
        var battle = new BattleContext();
        battle.executeStrategy(BattleStrategy.defensiveStrategy);
        battle.executeStrategy(BattleStrategy.guerillaStrategy);
        battle.executeStrategy(BattleStrategy.aggressiveStrategy);
    }
}

interface BattleStrategy {
    void execute();

    // Strategy implementations
    // these are in inplace of concrete classes, coz
    // there is only one method in the interface
    BattleStrategy aggressiveStrategy =
            () -> System.out.println("Attacking aggressively: Launching frontal assault!");
    BattleStrategy defensiveStrategy =
            () -> System.out.println("Defending: Building fortifications and preparing for seige!");
    BattleStrategy guerillaStrategy =
            () -> System.out.println("Using guerilla tactics: Hiding in shadows and ambushing enemy!");
}

class BattleContext {
    public void executeStrategy(BattleStrategy strategy) {
        strategy.execute();
    }
}