package com.example.mentalcounting.services;

import com.example.mentalcounting.models.operationModel;

public class OperationServices {

    public static operationModel generateOperation(){
        int a = (int)(1+Math.random() * ((100 ) + 1));
        int b =(int)(1+Math.random() * ((100 ) + 1));
        int operator = 1+(int)(Math.random() * 3);

        operationModel model = new operationModel(0,0,"+");
        switch (operator){
            case 1:
                model = new operationModel(a,b,"+");
                break;
            case 2:
                if(a-b>0)
                    model = new operationModel(a,b,"-");
                else
                    model = new operationModel(b,a,"-");
                break;
            case 3:
                model = new operationModel(a,b,"*");
                break;
            case 4:

                while(a%b!=0||a==b||a/b<0){
                    a = (int)(2+Math.random() * 98);
                    b =(int)(2+Math.random() * 98);
                }
                model = new operationModel(a,b,"/");
                break;
        }
        return model;
    }

   public static boolean resolveOperation(operationModel model, String reponse){
        int firstValue = model.getFirstValue();
        int secondValue = model.getSecondValue();
        String operator = model.getOperator();
        double reponseDouble = Double.parseDouble(reponse);
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
       System.out.println(result);
       System.out.println(reponseDouble);
        return result==reponseDouble;
    }
}
