package Lab_4;

// Model

public class CalculationData {
    private Operator OperatorAssigned, OperatorClicked;
    private double numberStored;

    public CalculationData() {
        numberStored = 0.0;
        OperatorAssigned = Operator.NULL;
        OperatorClicked = Operator.NULL;
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


}
