package onlyoffice.managers.convert;

import org.json.JSONObject;

import java.io.Serializable;

public interface ConvertManager extends Serializable {
    public boolean isConvertable(String ext);
    public String convertsTo(String ext);
    public String getMimeType(String ext);
    public JSONObject convert(Long attachmentId, String key,  String ext) throws Exception;
}
