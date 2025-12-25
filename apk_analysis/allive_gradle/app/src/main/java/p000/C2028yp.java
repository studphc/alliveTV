package p000;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.bind.C1060d;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: yp */
/* loaded from: classes2.dex */
public final class C2028yp extends TypeAdapter {

    /* renamed from: a */
    public final /* synthetic */ int f29054a = 0;

    /* renamed from: b */
    public final Object f29055b;

    /* renamed from: c */
    public final Object f29056c;

    public C2028yp(Gson gson, Type type, TypeAdapter typeAdapter, ObjectConstructor objectConstructor) {
        this.f29055b = new C1060d(gson, typeAdapter, type);
        this.f29056c = objectConstructor;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        switch (this.f29054a) {
            case 0:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                Collection collection = (Collection) ((ObjectConstructor) this.f29056c).construct();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    collection.add(((C1060d) this.f29055b).f15784b.read(jsonReader));
                }
                jsonReader.endArray();
                return collection;
            default:
                Object read = ((kx2) this.f29056c).f22245c.read(jsonReader);
                if (read != null) {
                    Class cls = (Class) this.f29055b;
                    if (!cls.isInstance(read)) {
                        throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + read.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
                    }
                }
                return read;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        switch (this.f29054a) {
            case 0:
                Collection collection = (Collection) obj;
                if (collection == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginArray();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    ((C1060d) this.f29055b).write(jsonWriter, it.next());
                }
                jsonWriter.endArray();
                return;
            default:
                ((kx2) this.f29056c).f22245c.write(jsonWriter, obj);
                return;
        }
    }

    public C2028yp(kx2 kx2Var, Class cls) {
        this.f29056c = kx2Var;
        this.f29055b = cls;
    }
}
