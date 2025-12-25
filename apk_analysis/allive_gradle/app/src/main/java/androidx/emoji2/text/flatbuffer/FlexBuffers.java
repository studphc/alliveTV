package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.UShort;
import kotlin.text.Typography;
import p000.ue0;
import p000.ve0;
import p000.x82;

/* loaded from: classes.dex */
public class FlexBuffers {
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    /* renamed from: a */
    public static final ArrayReadWriteBuf f4261a = new ArrayReadWriteBuf(new byte[]{0}, 1);

    /* loaded from: classes.dex */
    public static class Blob extends ve0 {

        /* renamed from: d */
        public static final Blob f4262d = new ve0(FlexBuffers.f4261a, 1, 1);

        public static Blob empty() {
            return f4262d;
        }

        public ByteBuffer data() {
            ByteBuffer wrap = ByteBuffer.wrap(this.f27236a.data());
            int i = this.f27237b;
            wrap.position(i);
            wrap.limit(size() + i);
            return wrap.asReadOnlyBuffer().slice();
        }

        public byte get(int i) {
            return this.f27236a.get(this.f27237b + i);
        }

        public byte[] getBytes() {
            int size = size();
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = this.f27236a.get(this.f27237b + i);
            }
            return bArr;
        }

        public int size() {
            return this.size;
        }

        @Override // p000.ue0
        public String toString() {
            return this.f27236a.getString(this.f27237b, size());
        }

        @Override // p000.ue0
        public StringBuilder toString(StringBuilder sb) {
            sb.append(Typography.quote);
            sb.append(this.f27236a.getString(this.f27237b, size()));
            sb.append(Typography.quote);
            return sb;
        }
    }

    /* loaded from: classes.dex */
    public static class FlexBufferException extends RuntimeException {
    }

    /* loaded from: classes.dex */
    public static class Key extends ue0 {

        /* renamed from: d */
        public static final Key f4263d = new ue0(FlexBuffers.f4261a, 0, 0);

        public static Key empty() {
            return f4263d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (key.f27237b != this.f27237b || key.f27238c != this.f27238c) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f27237b ^ this.f27238c;
        }

        @Override // p000.ue0
        public StringBuilder toString(StringBuilder sb) {
            sb.append(toString());
            return sb;
        }

        @Override // p000.ue0
        public String toString() {
            int i = this.f27237b;
            int i2 = i;
            while (true) {
                x82 x82Var = this.f27236a;
                if (x82Var.get(i2) == 0) {
                    return x82Var.getString(i, i2 - i);
                }
                i2++;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class KeyVector {

        /* renamed from: a */
        public final TypedVector f4264a;

        public KeyVector(TypedVector typedVector) {
            this.f4264a = typedVector;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [ue0, androidx.emoji2.text.flatbuffer.FlexBuffers$Key] */
        public Key get(int i) {
            if (i >= size()) {
                return Key.f4263d;
            }
            TypedVector typedVector = this.f4264a;
            int i2 = (i * typedVector.f27238c) + typedVector.f27237b;
            x82 x82Var = typedVector.f27236a;
            return new ue0(x82Var, FlexBuffers.m1066a(x82Var, i2, typedVector.f27238c), 1);
        }

        public int size() {
            return this.f4264a.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            int i = 0;
            while (true) {
                TypedVector typedVector = this.f4264a;
                if (i < typedVector.size()) {
                    typedVector.get(i).m1071a(sb);
                    if (i != typedVector.size() - 1) {
                        sb.append(", ");
                    }
                    i++;
                } else {
                    sb.append("]");
                    return sb.toString();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Map extends Vector {

        /* renamed from: e */
        public static final Map f4265e = new ve0(FlexBuffers.f4261a, 1, 1);

        public static Map empty() {
            return f4265e;
        }

        public Reference get(String str) {
            return get(str.getBytes(StandardCharsets.UTF_8));
        }

        public KeyVector keys() {
            int i = this.f27238c;
            int i2 = this.f27237b - (i * 3);
            x82 x82Var = this.f27236a;
            return new KeyVector(new TypedVector(x82Var, FlexBuffers.m1066a(x82Var, i2, i), (int) FlexBuffers.m1068c(x82Var, i2 + i, i), 4));
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, p000.ue0
        public StringBuilder toString(StringBuilder sb) {
            sb.append("{ ");
            KeyVector keys = keys();
            int size = size();
            Vector values = values();
            for (int i = 0; i < size; i++) {
                sb.append(Typography.quote);
                sb.append(keys.get(i).toString());
                sb.append("\" : ");
                sb.append(values.get(i).toString());
                if (i != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            return sb;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [ve0, androidx.emoji2.text.flatbuffer.FlexBuffers$Vector] */
        public Vector values() {
            return new ve0(this.f27236a, this.f27237b, this.f27238c);
        }

        public Reference get(byte[] bArr) {
            int i;
            byte b;
            byte b2;
            KeyVector keys = keys();
            int size = keys.size();
            int size2 = keys.size() - 1;
            int i2 = 0;
            while (true) {
                if (i2 > size2) {
                    i = -(i2 + 1);
                    break;
                }
                i = (i2 + size2) >>> 1;
                Key key = keys.get(i);
                int i3 = key.f27237b;
                int i4 = 0;
                do {
                    b = key.f27236a.get(i3);
                    b2 = bArr[i4];
                    if (b == 0) {
                        break;
                    }
                    i3++;
                    i4++;
                    if (i4 == bArr.length) {
                        break;
                    }
                } while (b == b2);
                int i5 = b - b2;
                if (i5 >= 0) {
                    if (i5 <= 0) {
                        break;
                    }
                    size2 = i - 1;
                } else {
                    i2 = i + 1;
                }
            }
            if (i >= 0 && i < size) {
                return get(i);
            }
            return Reference.f4266f;
        }
    }

    /* loaded from: classes.dex */
    public static class Reference {

        /* renamed from: f */
        public static final Reference f4266f = new Reference(FlexBuffers.f4261a, 0, 1, 0);

        /* renamed from: a */
        public final x82 f4267a;

        /* renamed from: b */
        public final int f4268b;

        /* renamed from: c */
        public final int f4269c;

        /* renamed from: d */
        public final int f4270d;

        /* renamed from: e */
        public final int f4271e;

        public Reference(x82 x82Var, int i, int i2, int i3) {
            this(x82Var, i, i2, 1 << (i3 & 3), i3 >> 2);
        }

        /* renamed from: a */
        public final StringBuilder m1071a(StringBuilder sb) {
            int i = this.f4271e;
            if (i != 36) {
                switch (i) {
                    case 0:
                        sb.append("null");
                        return sb;
                    case 1:
                    case 6:
                        sb.append(asLong());
                        return sb;
                    case 2:
                    case 7:
                        sb.append(asUInt());
                        return sb;
                    case 3:
                    case 8:
                        sb.append(asFloat());
                        return sb;
                    case 4:
                        Key asKey = asKey();
                        sb.append(Typography.quote);
                        StringBuilder key = asKey.toString(sb);
                        key.append(Typography.quote);
                        return key;
                    case 5:
                        sb.append(Typography.quote);
                        sb.append(asString());
                        sb.append(Typography.quote);
                        return sb;
                    case 9:
                        return asMap().toString(sb);
                    case 10:
                        return asVector().toString(sb);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new RuntimeException("not_implemented:" + i);
                    case 25:
                        return asBlob().toString(sb);
                    case 26:
                        sb.append(asBoolean());
                        return sb;
                    default:
                        return sb;
                }
            }
            sb.append(asVector());
            return sb;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [ve0, androidx.emoji2.text.flatbuffer.FlexBuffers$Blob] */
        public Blob asBlob() {
            if (!isBlob() && !isString()) {
                return Blob.empty();
            }
            int i = this.f4268b;
            int i2 = this.f4269c;
            x82 x82Var = this.f4267a;
            return new ve0(x82Var, FlexBuffers.m1066a(x82Var, i, i2), this.f4270d);
        }

        public boolean asBoolean() {
            if (isBoolean()) {
                if (this.f4267a.get(this.f4268b) == 0) {
                    return false;
                }
                return true;
            }
            if (asUInt() == 0) {
                return false;
            }
            return true;
        }

        public double asFloat() {
            int i = this.f4269c;
            int i2 = this.f4268b;
            x82 x82Var = this.f4267a;
            int i3 = this.f4271e;
            if (i3 == 3) {
                return FlexBuffers.m1067b(x82Var, i2, i);
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 5) {
                        int i4 = this.f4270d;
                        if (i3 != 6) {
                            if (i3 != 7) {
                                if (i3 != 8) {
                                    if (i3 != 10) {
                                        if (i3 != 26) {
                                            return 0.0d;
                                        }
                                    } else {
                                        return asVector().size();
                                    }
                                } else {
                                    return FlexBuffers.m1067b(x82Var, FlexBuffers.m1066a(x82Var, i2, i), i4);
                                }
                            } else {
                                return FlexBuffers.m1069d(x82Var, FlexBuffers.m1066a(x82Var, i2, i), i4);
                            }
                        } else {
                            return (int) FlexBuffers.m1068c(x82Var, FlexBuffers.m1066a(x82Var, i2, i), i4);
                        }
                    } else {
                        return Double.parseDouble(asString());
                    }
                }
                return FlexBuffers.m1069d(x82Var, i2, i);
            }
            return (int) FlexBuffers.m1068c(x82Var, i2, i);
        }

        public int asInt() {
            int i = this.f4268b;
            x82 x82Var = this.f4267a;
            int i2 = this.f4269c;
            int i3 = this.f4271e;
            if (i3 == 1) {
                return (int) FlexBuffers.m1068c(x82Var, i, i2);
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        int i4 = this.f4270d;
                        if (i3 != 6) {
                            if (i3 != 7) {
                                if (i3 != 8) {
                                    if (i3 != 10) {
                                        if (i3 != 26) {
                                            return 0;
                                        }
                                        return (int) FlexBuffers.m1068c(x82Var, i, i2);
                                    }
                                    return asVector().size();
                                }
                                return (int) FlexBuffers.m1067b(x82Var, FlexBuffers.m1066a(x82Var, i, i2), i4);
                            }
                            return (int) FlexBuffers.m1069d(x82Var, FlexBuffers.m1066a(x82Var, i, i2), i2);
                        }
                        return (int) FlexBuffers.m1068c(x82Var, FlexBuffers.m1066a(x82Var, i, i2), i4);
                    }
                    return Integer.parseInt(asString());
                }
                return (int) FlexBuffers.m1067b(x82Var, i, i2);
            }
            return (int) FlexBuffers.m1069d(x82Var, i, i2);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [ue0, androidx.emoji2.text.flatbuffer.FlexBuffers$Key] */
        public Key asKey() {
            if (isKey()) {
                int i = this.f4268b;
                int i2 = this.f4269c;
                x82 x82Var = this.f4267a;
                return new ue0(x82Var, FlexBuffers.m1066a(x82Var, i, i2), this.f4270d);
            }
            return Key.empty();
        }

        public long asLong() {
            int i = this.f4268b;
            x82 x82Var = this.f4267a;
            int i2 = this.f4269c;
            int i3 = this.f4271e;
            if (i3 == 1) {
                return FlexBuffers.m1068c(x82Var, i, i2);
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        int i4 = this.f4270d;
                        if (i3 != 6) {
                            if (i3 != 7) {
                                if (i3 != 8) {
                                    if (i3 != 10) {
                                        if (i3 != 26) {
                                            return 0L;
                                        }
                                        return (int) FlexBuffers.m1068c(x82Var, i, i2);
                                    }
                                    return asVector().size();
                                }
                                return (long) FlexBuffers.m1067b(x82Var, FlexBuffers.m1066a(x82Var, i, i2), i4);
                            }
                            return FlexBuffers.m1069d(x82Var, FlexBuffers.m1066a(x82Var, i, i2), i2);
                        }
                        return FlexBuffers.m1068c(x82Var, FlexBuffers.m1066a(x82Var, i, i2), i4);
                    }
                    try {
                        return Long.parseLong(asString());
                    } catch (NumberFormatException unused) {
                        return 0L;
                    }
                }
                return (long) FlexBuffers.m1067b(x82Var, i, i2);
            }
            return FlexBuffers.m1069d(x82Var, i, i2);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [ve0, androidx.emoji2.text.flatbuffer.FlexBuffers$Map] */
        public Map asMap() {
            if (isMap()) {
                int i = this.f4268b;
                int i2 = this.f4269c;
                x82 x82Var = this.f4267a;
                return new ve0(x82Var, FlexBuffers.m1066a(x82Var, i, i2), this.f4270d);
            }
            return Map.empty();
        }

        public String asString() {
            boolean isString = isString();
            int i = this.f4270d;
            int i2 = this.f4268b;
            x82 x82Var = this.f4267a;
            if (isString) {
                int m1066a = FlexBuffers.m1066a(x82Var, i2, this.f4269c);
                return x82Var.getString(m1066a, (int) FlexBuffers.m1069d(x82Var, m1066a - i, i));
            }
            if (isKey()) {
                int m1066a2 = FlexBuffers.m1066a(x82Var, i2, i);
                int i3 = m1066a2;
                while (x82Var.get(i3) != 0) {
                    i3++;
                }
                return x82Var.getString(m1066a2, i3 - m1066a2);
            }
            return "";
        }

        public long asUInt() {
            int i = this.f4268b;
            x82 x82Var = this.f4267a;
            int i2 = this.f4269c;
            int i3 = this.f4271e;
            if (i3 == 2) {
                return FlexBuffers.m1069d(x82Var, i, i2);
            }
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 10) {
                        if (i3 != 26) {
                            if (i3 != 5) {
                                int i4 = this.f4270d;
                                if (i3 != 6) {
                                    if (i3 != 7) {
                                        if (i3 != 8) {
                                            return 0L;
                                        }
                                        return (long) FlexBuffers.m1067b(x82Var, FlexBuffers.m1066a(x82Var, i, i2), i2);
                                    }
                                    return FlexBuffers.m1069d(x82Var, FlexBuffers.m1066a(x82Var, i, i2), i4);
                                }
                                return FlexBuffers.m1068c(x82Var, FlexBuffers.m1066a(x82Var, i, i2), i4);
                            }
                            return Long.parseLong(asString());
                        }
                        return (int) FlexBuffers.m1068c(x82Var, i, i2);
                    }
                    return asVector().size();
                }
                return (long) FlexBuffers.m1067b(x82Var, i, i2);
            }
            return FlexBuffers.m1068c(x82Var, i, i2);
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [ve0, androidx.emoji2.text.flatbuffer.FlexBuffers$Vector] */
        public Vector asVector() {
            boolean isVector = isVector();
            int i = this.f4270d;
            int i2 = this.f4269c;
            int i3 = this.f4268b;
            x82 x82Var = this.f4267a;
            if (isVector) {
                return new ve0(x82Var, FlexBuffers.m1066a(x82Var, i3, i2), i);
            }
            int i4 = this.f4271e;
            if (i4 == 15) {
                return new TypedVector(x82Var, FlexBuffers.m1066a(x82Var, i3, i2), i, 4);
            }
            if ((i4 >= 11 && i4 <= 15) || i4 == 36) {
                return new TypedVector(x82Var, FlexBuffers.m1066a(x82Var, i3, i2), i, i4 - 10);
            }
            return Vector.empty();
        }

        public int getType() {
            return this.f4271e;
        }

        public boolean isBlob() {
            if (this.f4271e == 25) {
                return true;
            }
            return false;
        }

        public boolean isBoolean() {
            if (this.f4271e == 26) {
                return true;
            }
            return false;
        }

        public boolean isFloat() {
            int i = this.f4271e;
            if (i != 3 && i != 8) {
                return false;
            }
            return true;
        }

        public boolean isInt() {
            int i = this.f4271e;
            if (i == 1 || i == 6) {
                return true;
            }
            return false;
        }

        public boolean isIntOrUInt() {
            if (!isInt() && !isUInt()) {
                return false;
            }
            return true;
        }

        public boolean isKey() {
            if (this.f4271e == 4) {
                return true;
            }
            return false;
        }

        public boolean isMap() {
            if (this.f4271e == 9) {
                return true;
            }
            return false;
        }

        public boolean isNull() {
            if (this.f4271e == 0) {
                return true;
            }
            return false;
        }

        public boolean isNumeric() {
            if (!isIntOrUInt() && !isFloat()) {
                return false;
            }
            return true;
        }

        public boolean isString() {
            if (this.f4271e == 5) {
                return true;
            }
            return false;
        }

        public boolean isTypedVector() {
            int i = this.f4271e;
            if ((i >= 11 && i <= 15) || i == 36) {
                return true;
            }
            return false;
        }

        public boolean isUInt() {
            int i = this.f4271e;
            if (i != 2 && i != 7) {
                return false;
            }
            return true;
        }

        public boolean isVector() {
            int i = this.f4271e;
            if (i != 10 && i != 9) {
                return false;
            }
            return true;
        }

        public String toString() {
            return m1071a(new StringBuilder(128)).toString();
        }

        public Reference(x82 x82Var, int i, int i2, int i3, int i4) {
            this.f4267a = x82Var;
            this.f4268b = i;
            this.f4269c = i2;
            this.f4270d = i3;
            this.f4271e = i4;
        }
    }

    /* loaded from: classes.dex */
    public static class TypedVector extends Vector {

        /* renamed from: f */
        public static final TypedVector f4272f = new TypedVector(FlexBuffers.f4261a, 1, 1, 1);

        /* renamed from: e */
        public final int f4273e;

        public TypedVector(x82 x82Var, int i, int i2, int i3) {
            super(x82Var, i, i2);
            this.f4273e = i3;
        }

        public static TypedVector empty() {
            return f4272f;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public Reference get(int i) {
            if (i >= size()) {
                return Reference.f4266f;
            }
            return new Reference(this.f27236a, (i * this.f27238c) + this.f27237b, this.f27238c, 1, this.f4273e);
        }

        public int getElemType() {
            return this.f4273e;
        }

        public boolean isEmptyVector() {
            if (this == f4272f) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class Vector extends ve0 {

        /* renamed from: d */
        public static final Vector f4274d = new ve0(FlexBuffers.f4261a, 1, 1);

        public static Vector empty() {
            return f4274d;
        }

        public Reference get(int i) {
            long size = size();
            long j = i;
            if (j >= size) {
                return Reference.f4266f;
            }
            int i2 = this.f27237b;
            int i3 = this.f27238c;
            long j2 = size * i3;
            x82 x82Var = this.f27236a;
            return new Reference(x82Var, (i * i3) + i2, i3, x82Var.get((int) (j2 + i2 + j)) & 255);
        }

        public boolean isEmpty() {
            if (this == f4274d) {
                return true;
            }
            return false;
        }

        public int size() {
            return this.size;
        }

        @Override // p000.ue0
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // p000.ue0
        public StringBuilder toString(StringBuilder sb) {
            sb.append("[ ");
            int size = size();
            for (int i = 0; i < size; i++) {
                get(i).m1071a(sb);
                if (i != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            return sb;
        }
    }

    /* renamed from: a */
    public static int m1066a(x82 x82Var, int i, int i2) {
        return (int) (i - m1069d(x82Var, i, i2));
    }

    /* renamed from: b */
    public static double m1067b(x82 x82Var, int i, int i2) {
        if (i2 != 4) {
            if (i2 != 8) {
                return -1.0d;
            }
            return x82Var.getDouble(i);
        }
        return x82Var.getFloat(i);
    }

    /* renamed from: c */
    public static long m1068c(x82 x82Var, int i, int i2) {
        int i3;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 != 8) {
                        return -1L;
                    }
                    return x82Var.getLong(i);
                }
                i3 = x82Var.getInt(i);
            } else {
                i3 = x82Var.getShort(i);
            }
        } else {
            i3 = x82Var.get(i);
        }
        return i3;
    }

    /* renamed from: d */
    public static long m1069d(x82 x82Var, int i, int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 != 8) {
                        return -1L;
                    }
                    return x82Var.getLong(i);
                }
                return x82Var.getInt(i) & 4294967295L;
            }
            return x82Var.getShort(i) & UShort.MAX_VALUE;
        }
        return x82Var.get(i) & 255;
    }

    /* renamed from: e */
    public static int m1070e(int i, int i2) {
        if (i2 == 0) {
            return i + 10;
        }
        if (i2 == 2) {
            return i + 15;
        }
        if (i2 == 3) {
            return i + 18;
        }
        if (i2 != 4) {
            return 0;
        }
        return i + 21;
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer byteBuffer) {
        return getRoot(byteBuffer.hasArray() ? new ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new ByteBufferReadWriteBuf(byteBuffer));
    }

    public static Reference getRoot(x82 x82Var) {
        int limit = x82Var.limit();
        byte b = x82Var.get(limit - 1);
        int i = limit - 2;
        return new Reference(x82Var, i - b, b, x82Var.get(i) & 255);
    }
}
