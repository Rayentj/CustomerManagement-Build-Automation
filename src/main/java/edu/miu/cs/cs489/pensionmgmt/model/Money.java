package edu.miu.cs.cs489.pensionmgmt.model;

import org.json.JSONObject;

public record Money (
    Double amount,
    String currency,
    String currencySymbol
) {
        public JSONObject toJSONObject() {
            var moneyJSONObject = new JSONObject();
            moneyJSONObject.put("amount", amount);
            moneyJSONObject.put("currency", currency);
            moneyJSONObject.put("currencySymbol", currencySymbol);
            return moneyJSONObject;
        }
    }
