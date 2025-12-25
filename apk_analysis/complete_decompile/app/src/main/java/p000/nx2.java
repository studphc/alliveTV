package p000;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class nx2 extends TypeAdapter {

    /* renamed from: a */
    public final /* synthetic */ int f23526a;

    public /* synthetic */ nx2(int i) {
        this.f23526a = i;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        switch (this.f23526a) {
            case 0:
                return new AtomicBoolean(jsonReader.nextBoolean());
            default:
                try {
                    return new AtomicInteger(jsonReader.nextInt());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        switch (this.f23526a) {
            case 0:
                jsonWriter.value(((AtomicBoolean) obj).get());
                return;
            default:
                jsonWriter.value(((AtomicInteger) obj).get());
                return;
        }
    }
}
