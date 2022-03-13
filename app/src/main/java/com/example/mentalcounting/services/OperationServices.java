package com.example.mentalcounting.services;

import com.example.mentalcounting.models.operationModel;

public class OperationServices {
    public operationModel genrateOperation(){
        int a = (int)(Math.random() * ((100 ) + 1));
        int b =(int)(Math.random() * ((100 ) + 1));
        int operator = 1+(int)(Math.random() * ((4 ) + 1));

        operationModel model = new operationModel(0,0,"+");
        switch (operator){
            case 1:
                model = new operationModel(a,b,"+");
                break;
            case 2:
                model = new operationModel(a,b,"-");
                break;
            case 3:
                model = new operationModel(a,b,"*");
                break;
            case 4:
                model = new operationModel(a,b,"/");
                break;
        }
        return model;
    }

    public boolean resolveOperation(operationModel model, double reponse){
        int firstValue = model.getFirstValue();
        int secondValue = model.getSecondValue();
        String operator = model.getOperator();
        double result=0;

        switch (operator) {
            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "*":
                result = firstValue * secondValue;
                break;
            case "/":
                result = firstValue / secondValue;
                break;
            //default:
               // throw new OperatorException("operator invalid");
        }

        return result==reponse;
    }
}
