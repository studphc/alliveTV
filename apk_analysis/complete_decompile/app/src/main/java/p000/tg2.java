package p000;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class tg2 implements Externalizable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public Map f26809a;

    static {
        final DefaultConstructorMarker defaultConstructorMarker = null;
        new Object(defaultConstructorMarker) { // from class: kotlin.collections.builders.SerializedMap$Companion
        };
    }

    private final Object readResolve() {
        return this.f26809a;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) {
        Intrinsics.checkNotNullParameter(input, "input");
        byte readByte = input.readByte();
        if (readByte == 0) {
            int readInt = input.readInt();
            if (readInt >= 0) {
                Map createMapBuilder = kh1.createMapBuilder(readInt);
                for (int i = 0; i < readInt; i++) {
                    createMapBuilder.put(input.readObject(), input.readObject());
                }
                this.f26809a = kh1.build(createMapBuilder);
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException(ye0.m8291k(readByte, "Unsupported flags value: "));
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(0);
        output.writeInt(this.f26809a.size());
        for (Map.Entry entry : this.f26809a.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }
}
