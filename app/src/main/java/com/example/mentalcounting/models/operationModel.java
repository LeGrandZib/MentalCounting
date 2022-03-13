package com.example.mentalcounting.models;

public class operationModel {
        private int _firstValue;
        private int _secondValue;
        private String _operator;

        public operationModel(
                int first,
                int second,
                String ope
        ){
            this._firstValue = first;
            this._secondValue = second;
            this._operator = ope;
        }

        public int getFirstValue() {
            return _firstValue;
        }

        public int getSecondValue() {
            return _secondValue;
        }

        public String getOperator() {
            return _operator;
        }
}
