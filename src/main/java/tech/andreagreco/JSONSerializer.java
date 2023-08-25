package tech.andreagreco;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;

public class JSONSerializer {
    public String bodyToJsonString(Object body) {
        Iterator<String> keys = body.keys();
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);
        String jsonString = "{";
        Boolean first = true;

        while(keys.hasNext()) {
            String key = keys.next();
            if (!first) {
                jsonString = jsonString + ",";
            } else {
                first = false;
            }

            if ((body.get(key) instanceof Double) || (body.get(key) instanceof Float)) {
                jsonString = jsonString + "\"" + key + "\":" + df.format(body.get(key));
            } else if ((body.get(key) instanceof Integer) || (body.get(key) instanceof Long)) {
                jsonString = jsonString + "\"" + key + "\":" + body.get(key).toString();
            } else if (body.get(key) instanceof Boolean) {
                jsonString = jsonString + "\"" + key + "\":" + body.get(key);
            } else {
                jsonString = jsonString + "\"" + key + "\":\"" + body.get(key).toString() + "\"";
            }
        }
        jsonString = jsonString + "}";
        return jsonString;
    }
}
