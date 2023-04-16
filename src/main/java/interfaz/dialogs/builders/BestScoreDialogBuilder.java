package interfaz.dialogs.builders;

import interfaz.InterfazSpaceInvaders;
import interfaz.dialogs.DialogBuilder;
import interfaz.dialogs.concrets.BestScore;

import java.util.ArrayList;

public class BestScoreDialogBuilder implements DialogBuilder {

    private BestScore bestScore;
    private final ArrayList<String> strings;

    public BestScoreDialogBuilder(ArrayList<String> strings) {
        this.strings = strings;
    }

    @Override
    public void setLayout() {
        bestScore = new BestScore(strings);
    }

    @Override
    public void reset() {
        bestScore = null;
    }

    @Override
    public void viewDialog() {
        bestScore.mostrar();
    }
}
