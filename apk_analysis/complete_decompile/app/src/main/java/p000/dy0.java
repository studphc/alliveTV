package p000;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes2.dex */
public final class dy0 extends TypeAdapter {

    /* renamed from: a */
    public final /* synthetic */ int f16609a;

    public /* synthetic */ dy0(int i) {
        this.f16609a = i;
    }

    /* renamed from: a */
    public static JsonElement m4642a(JsonReader jsonReader, JsonToken jsonToken) {
        int i = mx2.f23156a[jsonToken.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 6) {
                        jsonReader.nextNull();
                        return JsonNull.INSTANCE;
                    }
                    throw new IllegalStateException("Unexpected token: " + jsonToken);
                }
                return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
            }
            return new JsonPrimitive(jsonReader.nextString());
        }
        return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
    }

    /* renamed from: b */
    public static JsonElement m4643b(JsonReader jsonReader, JsonToken jsonToken) {
        int i = mx2.f23156a[jsonToken.ordinal()];
        if (i != 4) {
            if (i != 5) {
                return null;
            }
            jsonReader.beginObject();
            return new JsonObject();
        }
        jsonReader.beginArray();
        return new JsonArray();
    }

    /* renamed from: c */
    public static void m4644c(JsonElement jsonElement, JsonWriter jsonWriter) {
        if (jsonElement != null && !jsonElement.isJsonNull()) {
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    jsonWriter.value(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    jsonWriter.value(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    jsonWriter.value(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (jsonElement.isJsonArray()) {
                jsonWriter.beginArray();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    m4644c(it.next(), jsonWriter);
                }
                jsonWriter.endArray();
                return;
            }
            if (jsonElement.isJsonObject()) {
                jsonWriter.beginObject();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    m4644c(entry.getValue(), jsonWriter);
                }
                jsonWriter.endObject();
                return;
            }
            throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
        }
        jsonWriter.nullValue();
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        String str;
        String str2;
        String str3;
        boolean z;
        switch (this.f16609a) {
            case 0:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Double.valueOf(jsonReader.nextDouble());
            case 1:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Float.valueOf((float) jsonReader.nextDouble());
            case 2:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Long.valueOf(jsonReader.nextLong());
            case 3:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    try {
                        arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                    } catch (NumberFormatException e) {
                        throw new JsonSyntaxException(e);
                    }
                }
                jsonReader.endArray();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i = 0; i < size; i++) {
                    atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
                }
                return atomicIntegerArray;
            case 4:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Long.valueOf(jsonReader.nextLong());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            case 5:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Float.valueOf((float) jsonReader.nextDouble());
            case 6:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Double.valueOf(jsonReader.nextDouble());
            case 7:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String nextString = jsonReader.nextString();
                if (nextString.length() == 1) {
                    return Character.valueOf(nextString.charAt(0));
                }
                StringBuilder m7065u = AbstractC1726qj.m7065u("Expecting character, got: ", nextString, "; at ");
                m7065u.append(jsonReader.getPreviousPath());
                throw new JsonSyntaxException(m7065u.toString());
            case 8:
                JsonToken peek = jsonReader.peek();
                if (peek == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                if (peek == JsonToken.BOOLEAN) {
                    return Boolean.toString(jsonReader.nextBoolean());
                }
                return jsonReader.nextString();
            case 9:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String nextString2 = jsonReader.nextString();
                try {
                    return new BigDecimal(nextString2);
                } catch (NumberFormatException e3) {
                    StringBuilder m7065u2 = AbstractC1726qj.m7065u("Failed parsing '", nextString2, "' as BigDecimal; at path ");
                    m7065u2.append(jsonReader.getPreviousPath());
                    throw new JsonSyntaxException(m7065u2.toString(), e3);
                }
            case 10:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String nextString3 = jsonReader.nextString();
                try {
                    return new BigInteger(nextString3);
                } catch (NumberFormatException e4) {
                    StringBuilder m7065u3 = AbstractC1726qj.m7065u("Failed parsing '", nextString3, "' as BigInteger; at path ");
                    m7065u3.append(jsonReader.getPreviousPath());
                    throw new JsonSyntaxException(m7065u3.toString(), e4);
                }
            case 11:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return new LazilyParsedNumber(jsonReader.nextString());
            case 12:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return new StringBuilder(jsonReader.nextString());
            case 13:
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            case 14:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return new StringBuffer(jsonReader.nextString());
            case 15:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String nextString4 = jsonReader.nextString();
                if ("null".equals(nextString4)) {
                    return null;
                }
                return new URL(nextString4);
            case 16:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    String nextString5 = jsonReader.nextString();
                    if ("null".equals(nextString5)) {
                        return null;
                    }
                    return new URI(nextString5);
                } catch (URISyntaxException e5) {
                    throw new JsonIOException(e5);
                }
            case 17:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return InetAddress.getByName(jsonReader.nextString());
            case 18:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String nextString6 = jsonReader.nextString();
                try {
                    return UUID.fromString(nextString6);
                } catch (IllegalArgumentException e6) {
                    StringBuilder m7065u4 = AbstractC1726qj.m7065u("Failed parsing '", nextString6, "' as UUID; at path ");
                    m7065u4.append(jsonReader.getPreviousPath());
                    throw new JsonSyntaxException(m7065u4.toString(), e6);
                }
            case 19:
                String nextString7 = jsonReader.nextString();
                try {
                    return Currency.getInstance(nextString7);
                } catch (IllegalArgumentException e7) {
                    StringBuilder m7065u5 = AbstractC1726qj.m7065u("Failed parsing '", nextString7, "' as Currency; at path ");
                    m7065u5.append(jsonReader.getPreviousPath());
                    throw new JsonSyntaxException(m7065u5.toString(), e7);
                }
            case 20:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                jsonReader.beginObject();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String nextName = jsonReader.nextName();
                    int nextInt = jsonReader.nextInt();
                    if ("year".equals(nextName)) {
                        i2 = nextInt;
                    } else if ("month".equals(nextName)) {
                        i3 = nextInt;
                    } else if ("dayOfMonth".equals(nextName)) {
                        i4 = nextInt;
                    } else if ("hourOfDay".equals(nextName)) {
                        i5 = nextInt;
                    } else if ("minute".equals(nextName)) {
                        i6 = nextInt;
                    } else if ("second".equals(nextName)) {
                        i7 = nextInt;
                    }
                }
                jsonReader.endObject();
                return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
            case 21:
                String str4 = null;
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
                if (stringTokenizer.hasMoreElements()) {
                    str = stringTokenizer.nextToken();
                } else {
                    str = null;
                }
                if (stringTokenizer.hasMoreElements()) {
                    str2 = stringTokenizer.nextToken();
                } else {
                    str2 = null;
                }
                if (stringTokenizer.hasMoreElements()) {
                    str4 = stringTokenizer.nextToken();
                }
                if (str2 == null && str4 == null) {
                    return new Locale(str);
                }
                if (str4 == null) {
                    return new Locale(str, str2);
                }
                return new Locale(str, str2, str4);
            case 22:
                if (jsonReader instanceof JsonTreeReader) {
                    JsonTreeReader jsonTreeReader = (JsonTreeReader) jsonReader;
                    JsonToken peek2 = jsonTreeReader.peek();
                    if (peek2 != JsonToken.NAME && peek2 != JsonToken.END_ARRAY && peek2 != JsonToken.END_OBJECT && peek2 != JsonToken.END_DOCUMENT) {
                        JsonElement jsonElement = (JsonElement) jsonTreeReader.m4431d();
                        jsonTreeReader.skipValue();
                        return jsonElement;
                    }
                    throw new IllegalStateException("Unexpected " + peek2 + " when reading a JsonElement.");
                }
                JsonToken peek3 = jsonReader.peek();
                JsonElement m4643b = m4643b(jsonReader, peek3);
                if (m4643b == null) {
                    return m4642a(jsonReader, peek3);
                }
                ArrayDeque arrayDeque = new ArrayDeque();
                while (true) {
                    if (jsonReader.hasNext()) {
                        if (m4643b instanceof JsonObject) {
                            str3 = jsonReader.nextName();
                        } else {
                            str3 = null;
                        }
                        JsonToken peek4 = jsonReader.peek();
                        JsonElement m4643b2 = m4643b(jsonReader, peek4);
                        if (m4643b2 != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (m4643b2 == null) {
                            m4643b2 = m4642a(jsonReader, peek4);
                        }
                        if (m4643b instanceof JsonArray) {
                            ((JsonArray) m4643b).add(m4643b2);
                        } else {
                            ((JsonObject) m4643b).add(str3, m4643b2);
                        }
                        if (z) {
                            arrayDeque.addLast(m4643b);
                            m4643b = m4643b2;
                        }
                    } else {
                        if (m4643b instanceof JsonArray) {
                            jsonReader.endArray();
                        } else {
                            jsonReader.endObject();
                        }
                        if (arrayDeque.isEmpty()) {
                            return m4643b;
                        }
                        m4643b = (JsonElement) arrayDeque.removeLast();
                    }
                }
                break;
            case 23:
                BitSet bitSet = new BitSet();
                jsonReader.beginArray();
                JsonToken peek5 = jsonReader.peek();
                int i8 = 0;
                while (peek5 != JsonToken.END_ARRAY) {
                    int i9 = mx2.f23156a[peek5.ordinal()];
                    boolean z2 = true;
                    if (i9 != 1 && i9 != 2) {
                        if (i9 == 3) {
                            z2 = jsonReader.nextBoolean();
                        } else {
                            throw new JsonSyntaxException("Invalid bitset value type: " + peek5 + "; at path " + jsonReader.getPath());
                        }
                    } else {
                        int nextInt2 = jsonReader.nextInt();
                        if (nextInt2 == 0) {
                            z2 = false;
                        } else if (nextInt2 != 1) {
                            StringBuilder m8299s = ye0.m8299s(nextInt2, "Invalid bitset value ", ", expected 0 or 1; at path ");
                            m8299s.append(jsonReader.getPreviousPath());
                            throw new JsonSyntaxException(m8299s.toString());
                        }
                    }
                    if (z2) {
                        bitSet.set(i8);
                    }
                    i8++;
                    peek5 = jsonReader.peek();
                }
                jsonReader.endArray();
                return bitSet;
            case 24:
                JsonToken peek6 = jsonReader.peek();
                if (peek6 == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                if (peek6 == JsonToken.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
                }
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 25:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Boolean.valueOf(jsonReader.nextString());
            case 26:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    int nextInt3 = jsonReader.nextInt();
                    if (nextInt3 <= 255 && nextInt3 >= -128) {
                        return Byte.valueOf((byte) nextInt3);
                    }
                    StringBuilder m8299s2 = ye0.m8299s(nextInt3, "Lossy conversion from ", " to byte; at path ");
                    m8299s2.append(jsonReader.getPreviousPath());
                    throw new JsonSyntaxException(m8299s2.toString());
                } catch (NumberFormatException e8) {
                    throw new JsonSyntaxException(e8);
                }
            case 27:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    int nextInt4 = jsonReader.nextInt();
                    if (nextInt4 <= 65535 && nextInt4 >= -32768) {
                        return Short.valueOf((short) nextInt4);
                    }
                    StringBuilder m8299s3 = ye0.m8299s(nextInt4, "Lossy conversion from ", " to short; at path ");
                    m8299s3.append(jsonReader.getPreviousPath());
                    throw new JsonSyntaxException(m8299s3.toString());
                } catch (NumberFormatException e9) {
                    throw new JsonSyntaxException(e9);
                }
            default:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Integer.valueOf(jsonReader.nextInt());
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException(e10);
                }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        String valueOf;
        String sb;
        String stringBuffer;
        String externalForm;
        String aSCIIString;
        String hostAddress;
        String uuid;
        String locale;
        String bool;
        switch (this.f16609a) {
            case 0:
                Number number = (Number) obj;
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                double doubleValue = number.doubleValue();
                Gson.m4411a(doubleValue);
                jsonWriter.value(doubleValue);
                return;
            case 1:
                Number number2 = (Number) obj;
                if (number2 == null) {
                    jsonWriter.nullValue();
                    return;
                }
                float floatValue = number2.floatValue();
                Gson.m4411a(floatValue);
                if (!(number2 instanceof Float)) {
                    number2 = Float.valueOf(floatValue);
                }
                jsonWriter.value(number2);
                return;
            case 2:
                Number number3 = (Number) obj;
                if (number3 == null) {
                    jsonWriter.nullValue();
                    return;
                } else {
                    jsonWriter.value(number3.toString());
                    return;
                }
            case 3:
                jsonWriter.beginArray();
                int length = ((AtomicIntegerArray) obj).length();
                for (int i = 0; i < length; i++) {
                    jsonWriter.value(r6.get(i));
                }
                jsonWriter.endArray();
                return;
            case 4:
                Number number4 = (Number) obj;
                if (number4 == null) {
                    jsonWriter.nullValue();
                    return;
                } else {
                    jsonWriter.value(number4.longValue());
                    return;
                }
            case 5:
                Number number5 = (Number) obj;
                if (number5 == null) {
                    jsonWriter.nullValue();
                    return;
                }
                if (!(number5 instanceof Float)) {
                    number5 = Float.valueOf(number5.floatValue());
                }
                jsonWriter.value(number5);
                return;
            case 6:
                Number number6 = (Number) obj;
                if (number6 == null) {
                    jsonWriter.nullValue();
                    return;
                } else {
                    jsonWriter.value(number6.doubleValue());
                    return;
                }
            case 7:
                Character ch = (Character) obj;
                if (ch == null) {
                    valueOf = null;
                } else {
                    valueOf = String.valueOf(ch);
                }
                jsonWriter.value(valueOf);
                return;
            case 8:
                jsonWriter.value((String) obj);
                return;
            case 9:
                jsonWriter.value((BigDecimal) obj);
                return;
            case 10:
                jsonWriter.value((BigInteger) obj);
                return;
            case 11:
                jsonWriter.value((LazilyParsedNumber) obj);
                return;
            case 12:
                StringBuilder sb2 = (StringBuilder) obj;
                if (sb2 == null) {
                    sb = null;
                } else {
                    sb = sb2.toString();
                }
                jsonWriter.value(sb);
                return;
            case 13:
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?");
            case 14:
                StringBuffer stringBuffer2 = (StringBuffer) obj;
                if (stringBuffer2 == null) {
                    stringBuffer = null;
                } else {
                    stringBuffer = stringBuffer2.toString();
                }
                jsonWriter.value(stringBuffer);
                return;
            case 15:
                URL url = (URL) obj;
                if (url == null) {
                    externalForm = null;
                } else {
                    externalForm = url.toExternalForm();
                }
                jsonWriter.value(externalForm);
                return;
            case 16:
                URI uri = (URI) obj;
                if (uri == null) {
                    aSCIIString = null;
                } else {
                    aSCIIString = uri.toASCIIString();
                }
                jsonWriter.value(aSCIIString);
                return;
            case 17:
                InetAddress inetAddress = (InetAddress) obj;
                if (inetAddress == null) {
                    hostAddress = null;
                } else {
                    hostAddress = inetAddress.getHostAddress();
                }
                jsonWriter.value(hostAddress);
                return;
            case 18:
                UUID uuid2 = (UUID) obj;
                if (uuid2 == null) {
                    uuid = null;
                } else {
                    uuid = uuid2.toString();
                }
                jsonWriter.value(uuid);
                return;
            case 19:
                jsonWriter.value(((Currency) obj).getCurrencyCode());
                return;
            case 20:
                if (((Calendar) obj) == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginObject();
                jsonWriter.name("year");
                jsonWriter.value(r6.get(1));
                jsonWriter.name("month");
                jsonWriter.value(r6.get(2));
                jsonWriter.name("dayOfMonth");
                jsonWriter.value(r6.get(5));
                jsonWriter.name("hourOfDay");
                jsonWriter.value(r6.get(11));
                jsonWriter.name("minute");
                jsonWriter.value(r6.get(12));
                jsonWriter.name("second");
                jsonWriter.value(r6.get(13));
                jsonWriter.endObject();
                return;
            case 21:
                Locale locale2 = (Locale) obj;
                if (locale2 == null) {
                    locale = null;
                } else {
                    locale = locale2.toString();
                }
                jsonWriter.value(locale);
                return;
            case 22:
                m4644c((JsonElement) obj, jsonWriter);
                return;
            case 23:
                BitSet bitSet = (BitSet) obj;
                jsonWriter.beginArray();
                int length2 = bitSet.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    jsonWriter.value(bitSet.get(i2) ? 1L : 0L);
                }
                jsonWriter.endArray();
                return;
            case 24:
                jsonWriter.value((Boolean) obj);
                return;
            case 25:
                Boolean bool2 = (Boolean) obj;
                if (bool2 == null) {
                    bool = "null";
                } else {
                    bool = bool2.toString();
                }
                jsonWriter.value(bool);
                return;
            case 26:
                if (((Number) obj) == null) {
                    jsonWriter.nullValue();
                    return;
                } else {
                    jsonWriter.value(r6.byteValue());
                    return;
                }
            case 27:
                if (((Number) obj) == null) {
                    jsonWriter.nullValue();
                    return;
                } else {
                    jsonWriter.value(r6.shortValue());
                    return;
                }
            default:
                if (((Number) obj) == null) {
                    jsonWriter.nullValue();
                    return;
                } else {
                    jsonWriter.value(r6.intValue());
                    return;
                }
        }
    }
}
