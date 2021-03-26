package Lab_4;

// Model

public class CalculationData {
    private Operator OperatorAssigned, OperatorClicked;
    private double numberStored;
    private boolean isNumberButtonClicked, isOperatorClicked;

    public CalculationData() {
        numberStored = 0.0;
        OperatorAssigned = Operator.NULL;
        OperatorClicked = Operator.NULL;
        isNumberButtonClicked = false;
        isOperatorClicked = false;
    }

    public double getNumberStored() {
        return numberStored;
    }

    public Operator getOperatorAssigned() {
        return OperatorAssigned;
    }

    public Operator getOperatorClicked() {
        return OperatorClicked;
    }

    public boolean getNumberButtonClickStatus() {
        return isNumberButtonClicked;
    }

    public boolean getOperatorButtonClickStatus() {
        return isOperatorClicked;
    }

    public void setOperatorClicked(Operator operatorClicked) {
        this.OperatorClicked = operatorClicked;
    }

    public void setOperationAssigned(Operator operationAssigned) {
        this.OperatorAssigned = operationAssigned;
    }

    public void updateOperatorAssigned() {
        OperatorAssigned = OperatorClicked;
    }

    public void setNumberStored(double numberStored) {
        this.numberStored = numberStored;
    }

    public void setNumberButtonClickStatus(boolean status) {
        isNumberButtonClicked = status;
    }

    public void setOperatorButtonClickStatus(boolean status) {
        isOperatorClicked = status;
    }


}
