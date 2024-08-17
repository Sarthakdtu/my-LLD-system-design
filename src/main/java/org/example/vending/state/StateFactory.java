package org.example.vending.state;

import org.example.vending.state.impl.DispenseState;
import org.example.vending.state.impl.HasCoinState;
import org.example.vending.state.impl.IdleState;
import org.example.vending.state.impl.SelectionState;

public class StateFactory {

    private static StateFactory instance;

    private State idleState;
    private State selectionState;
    private State moneyState;
    private State dispenseState;

    private StateFactory(){
        idleState = new IdleState();
        selectionState = new SelectionState();
        dispenseState = new DispenseState();
        moneyState = new HasCoinState();
    }

    public static StateFactory getInstance() {
        if(instance == null){
            instance = new StateFactory();
        }
        return instance;
    }

    public State getIdleState() {
        return idleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public State getMoneyState() {
        return moneyState;
    }

    public State getSelectionState() {
        return selectionState;
    }
}
