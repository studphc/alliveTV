package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p000.ye0;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public abstract class FastJsonResponse {

    @ShowFirstParty
    /* loaded from: classes.dex */
    public interface FieldConverter<I, O> {
        int zaa();

        int zab();

        @Nullable
        Object zac(@NonNull Object obj);

        @NonNull
        Object zad(@NonNull Object obj);
    }

    /* renamed from: b */
    public static final void m3177b(StringBuilder sb, Field field, Object obj) {
        int i = field.zaa;
        if (i != 11) {
            if (i == 7) {
                sb.append("\"");
                sb.append(JsonUtils.escapeString((String) obj));
                sb.append("\"");
                return;
            }
            sb.append(obj);
            return;
        }
        Class cls = field.zag;
        Preconditions.checkNotNull(cls);
        sb.append(((FastJsonResponse) cls.cast(obj)).toString());
    }

    /* renamed from: c */
    public static final void m3178c(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            Log.e("FastJsonResponse", "Output field (" + str + ") has a null value, but expected a primitive");
        }
    }

    @NonNull
    public static final Object zaD(@NonNull Field field, @Nullable Object obj) {
        if (field.f13579c != null) {
            return field.zaf(obj);
        }
        return obj;
    }

    /* renamed from: a */
    public final void m3179a(Field field, Object obj) {
        int i = field.zac;
        Object zae = field.zae(obj);
        String str = field.zae;
        switch (i) {
            case 0:
                if (zae != null) {
                    setIntegerInternal(field, str, ((Integer) zae).intValue());
                    return;
                } else {
                    m3178c(str);
                    return;
                }
            case 1:
                zaf(field, str, (BigInteger) zae);
                return;
            case 2:
                if (zae != null) {
                    setLongInternal(field, str, ((Long) zae).longValue());
                    return;
                } else {
                    m3178c(str);
                    return;
                }
            case 3:
            default:
                throw new IllegalStateException(ye0.m8291k(i, "Unsupported type for conversion: "));
            case 4:
                if (zae != null) {
                    zan(field, str, ((Double) zae).doubleValue());
                    return;
                } else {
                    m3178c(str);
                    return;
                }
            case 5:
                zab(field, str, (BigDecimal) zae);
                return;
            case 6:
                if (zae != null) {
                    setBooleanInternal(field, str, ((Boolean) zae).booleanValue());
                    return;
                } else {
                    m3178c(str);
                    return;
                }
            case 7:
                setStringInternal(field, str, (String) zae);
                return;
            case 8:
            case 9:
                if (zae != null) {
                    setDecodedBytesInternal(field, str, (byte[]) zae);
                    return;
                } else {
                    m3178c(str);
                    return;
                }
        }
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(@NonNull Field field, @NonNull String str, @Nullable ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeInternal(@NonNull Field field, @NonNull String str, @NonNull T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    @NonNull
    @KeepForSdk
    public abstract Map<String, Field<?, ?>> getFieldMappings();

    @Nullable
    @KeepForSdk
    public Object getFieldValue(@NonNull Field field) {
        boolean z;
        String str = field.zae;
        if (field.zag != null) {
            if (getValueObject(str) == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Concrete field shouldn't be value object: %s", field.zae);
            try {
                return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), null).invoke(this, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return getValueObject(str);
    }

    @Nullable
    @KeepForSdk
    public abstract Object getValueObject(@NonNull String str);

    @KeepForSdk
    public boolean isFieldSet(@NonNull Field field) {
        if (field.zac == 11) {
            if (field.zad) {
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            }
            throw new UnsupportedOperationException("Concrete types not supported");
        }
        return isPrimitiveFieldSet(field.zae);
    }

    @KeepForSdk
    public abstract boolean isPrimitiveFieldSet(@NonNull String str);

    @KeepForSdk
    public void setBooleanInternal(@NonNull Field<?, ?> field, @NonNull String str, boolean z) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    @KeepForSdk
    public void setDecodedBytesInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    @KeepForSdk
    public void setIntegerInternal(@NonNull Field<?, ?> field, @NonNull String str, int i) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    @KeepForSdk
    public void setLongInternal(@NonNull Field<?, ?> field, @NonNull String str, long j) {
        throw new UnsupportedOperationException("Long not supported");
    }

    @KeepForSdk
    public void setStringInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    @KeepForSdk
    public void setStringMapInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    @KeepForSdk
    public void setStringsInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    @NonNull
    @KeepForSdk
    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field<?, ?> field = fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object zaD = zaD(field, getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (zaD == null) {
                    sb.append("null");
                } else {
                    switch (field.zac) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64Utils.encode((byte[]) zaD));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64Utils.encodeUrlSafe((byte[]) zaD));
                            sb.append("\"");
                            break;
                        case 10:
                            MapUtils.writeStringMapToJson(sb, (HashMap) zaD);
                            break;
                        default:
                            if (field.zab) {
                                ArrayList arrayList = (ArrayList) zaD;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        m3177b(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            } else {
                                m3177b(sb, field, zaD);
                                break;
                            }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    public final void zaA(@NonNull Field field, @Nullable String str) {
        if (field.f13579c != null) {
            m3179a(field, str);
        } else {
            setStringInternal(field, field.zae, str);
        }
    }

    public final void zaB(@NonNull Field field, @Nullable Map map) {
        if (field.f13579c != null) {
            m3179a(field, map);
        } else {
            setStringMapInternal(field, field.zae, map);
        }
    }

    public final void zaC(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f13579c != null) {
            m3179a(field, arrayList);
        } else {
            setStringsInternal(field, field.zae, arrayList);
        }
    }

    public final void zaa(@NonNull Field field, @Nullable BigDecimal bigDecimal) {
        if (field.f13579c != null) {
            m3179a(field, bigDecimal);
        } else {
            zab(field, field.zae, bigDecimal);
        }
    }

    public void zab(@NonNull Field field, @NonNull String str, @Nullable BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final void zac(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f13579c != null) {
            m3179a(field, arrayList);
        } else {
            zad(field, field.zae, arrayList);
        }
    }

    public void zad(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final void zae(@NonNull Field field, @Nullable BigInteger bigInteger) {
        if (field.f13579c != null) {
            m3179a(field, bigInteger);
        } else {
            zaf(field, field.zae, bigInteger);
        }
    }

    public void zaf(@NonNull Field field, @NonNull String str, @Nullable BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final void zag(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f13579c != null) {
            m3179a(field, arrayList);
        } else {
            zah(field, field.zae, arrayList);
        }
    }

    public void zah(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final void zai(@NonNull Field field, boolean z) {
        if (field.f13579c != null) {
            m3179a(field, Boolean.valueOf(z));
        } else {
            setBooleanInternal(field, field.zae, z);
        }
    }

    public final void zaj(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f13579c != null) {
            m3179a(field, arrayList);
        } else {
            zak(field, field.zae, arrayList);
        }
    }

    public void zak(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zal(@NonNull Field field, @Nullable byte[] bArr) {
        if (field.f13579c != null) {
            m3179a(field, bArr);
        } else {
            setDecodedBytesInternal(field, field.zae, bArr);
        }
    }

    public final void zam(@NonNull Field field, double d) {
        if (field.f13579c != null) {
            m3179a(field, Double.valueOf(d));
        } else {
            zan(field, field.zae, d);
        }
    }

    public void zan(@NonNull Field field, @NonNull String str, double d) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final void zao(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f13579c != null) {
            m3179a(field, arrayList);
        } else {
            zap(field, field.zae, arrayList);
        }
    }

    public void zap(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final void zaq(@NonNull Field field, float f) {
        if (field.f13579c != null) {
            m3179a(field, Float.valueOf(f));
        } else {
            zar(field, field.zae, f);
        }
    }

    public void zar(@NonNull Field field, @NonNull String str, float f) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final void zas(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f13579c != null) {
            m3179a(field, arrayList);
        } else {
            zat(field, field.zae, arrayList);
        }
    }

    public void zat(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final void zau(@NonNull Field field, int i) {
        if (field.f13579c != null) {
            m3179a(field, Integer.valueOf(i));
        } else {
            setIntegerInternal(field, field.zae, i);
        }
    }

    public final void zav(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f13579c != null) {
            m3179a(field, arrayList);
        } else {
            zaw(field, field.zae, arrayList);
        }
    }

    public void zaw(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final void zax(@NonNull Field field, long j) {
        if (field.f13579c != null) {
            m3179a(field, Long.valueOf(j));
        } else {
            setLongInternal(field, field.zae, j);
        }
    }

    public final void zay(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f13579c != null) {
            m3179a(field, arrayList);
        } else {
            zaz(field, field.zae, arrayList);
        }
    }

    public void zaz(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    @SafeParcelable.Class(creator = "FieldCreator")
    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zaj CREATOR = new zaj();

        /* renamed from: a */
        public final int f13577a;

        /* renamed from: b */
        public zan f13578b;

        /* renamed from: c */
        public final FieldConverter f13579c;

        @SafeParcelable.Field(getter = "getTypeIn", m3159id = 2)
        protected final int zaa;

        @SafeParcelable.Field(getter = "isTypeInArray", m3159id = 3)
        protected final boolean zab;

        @SafeParcelable.Field(getter = "getTypeOut", m3159id = 4)
        protected final int zac;

        @SafeParcelable.Field(getter = "isTypeOutArray", m3159id = 5)
        protected final boolean zad;

        @NonNull
        @SafeParcelable.Field(getter = "getOutputFieldName", m3159id = 6)
        protected final String zae;

        @SafeParcelable.Field(getter = "getSafeParcelableFieldId", m3159id = 7)
        protected final int zaf;

        @Nullable
        protected final Class zag;

        @Nullable
        @SafeParcelable.Field(getter = "getConcreteTypeName", m3159id = 8)
        protected final String zah;

        public Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, zaa zaaVar) {
            this.f13577a = i;
            this.zaa = i2;
            this.zab = z;
            this.zac = i3;
            this.zad = z2;
            this.zae = str;
            this.zaf = i4;
            if (str2 == null) {
                this.zag = null;
                this.zah = null;
            } else {
                this.zag = SafeParcelResponse.class;
                this.zah = str2;
            }
            if (zaaVar == null) {
                this.f13579c = null;
            } else {
                this.f13579c = zaaVar.zab();
            }
        }

        @NonNull
        @KeepForSdk
        public static Field<byte[], byte[]> forBase64(@NonNull String str, int i) {
            return new Field<>(8, false, 8, false, str, i, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Boolean, Boolean> forBoolean(@NonNull String str, int i) {
            return new Field<>(6, false, 6, false, str, i, null, null);
        }

        @NonNull
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(@NonNull String str, int i, @NonNull Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i, cls, null);
        }

        @NonNull
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(@NonNull String str, int i, @NonNull Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i, cls, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Double, Double> forDouble(@NonNull String str, int i) {
            return new Field<>(4, false, 4, false, str, i, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Float, Float> forFloat(@NonNull String str, int i) {
            return new Field<>(3, false, 3, false, str, i, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Integer, Integer> forInteger(@NonNull String str, int i) {
            return new Field<>(0, false, 0, false, str, i, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Long, Long> forLong(@NonNull String str, int i) {
            return new Field<>(2, false, 2, false, str, i, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<String, String> forString(@NonNull String str, int i) {
            return new Field<>(7, false, 7, false, str, i, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(@NonNull String str, int i) {
            return new Field<>(10, false, 10, false, str, i, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<ArrayList<String>, ArrayList<String>> forStrings(@NonNull String str, int i) {
            return new Field<>(7, true, 7, true, str, i, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field withConverter(@NonNull String str, int i, @NonNull FieldConverter<?, ?> fieldConverter, boolean z) {
            fieldConverter.zaa();
            fieldConverter.zab();
            return new Field(7, z, 0, false, str, i, null, fieldConverter);
        }

        @KeepForSdk
        public int getSafeParcelableFieldId() {
            return this.zaf;
        }

        @NonNull
        public final String toString() {
            Objects.ToStringHelper add = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.f13577a)).add("typeIn", Integer.valueOf(this.zaa)).add("typeInArray", Boolean.valueOf(this.zab)).add("typeOut", Integer.valueOf(this.zac)).add("typeOutArray", Boolean.valueOf(this.zad)).add("outputFieldName", this.zae).add("safeParcelFieldId", Integer.valueOf(this.zaf));
            String str = this.zah;
            if (str == null) {
                str = null;
            }
            Objects.ToStringHelper add2 = add.add("concreteTypeName", str);
            Class cls = this.zag;
            if (cls != null) {
                add2.add("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter fieldConverter = this.f13579c;
            if (fieldConverter != null) {
                add2.add("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return add2.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NonNull Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.f13577a);
            SafeParcelWriter.writeInt(parcel, 2, this.zaa);
            SafeParcelWriter.writeBoolean(parcel, 3, this.zab);
            SafeParcelWriter.writeInt(parcel, 4, this.zac);
            SafeParcelWriter.writeBoolean(parcel, 5, this.zad);
            SafeParcelWriter.writeString(parcel, 6, this.zae, false);
            SafeParcelWriter.writeInt(parcel, 7, getSafeParcelableFieldId());
            String str = this.zah;
            zaa zaaVar = null;
            if (str == null) {
                str = null;
            }
            SafeParcelWriter.writeString(parcel, 8, str, false);
            FieldConverter fieldConverter = this.f13579c;
            if (fieldConverter != null) {
                zaaVar = zaa.zaa(fieldConverter);
            }
            SafeParcelWriter.writeParcelable(parcel, 9, zaaVar, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @NonNull
        public final Field zab() {
            zaa zaa;
            int i = this.zaa;
            boolean z = this.zab;
            int i2 = this.zac;
            boolean z2 = this.zad;
            String str = this.zae;
            int i3 = this.zaf;
            String str2 = this.zah;
            FieldConverter fieldConverter = this.f13579c;
            if (fieldConverter == null) {
                zaa = null;
            } else {
                zaa = zaa.zaa(fieldConverter);
            }
            return new Field(this.f13577a, i, z, i2, z2, str, i3, str2, zaa);
        }

        @NonNull
        public final FastJsonResponse zad() {
            Preconditions.checkNotNull(this.zag);
            Class cls = this.zag;
            if (cls == SafeParcelResponse.class) {
                Preconditions.checkNotNull(this.zah);
                Preconditions.checkNotNull(this.f13578b, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
                return new SafeParcelResponse(this.f13578b, this.zah);
            }
            return (FastJsonResponse) cls.newInstance();
        }

        @NonNull
        public final Object zae(@Nullable Object obj) {
            FieldConverter fieldConverter = this.f13579c;
            Preconditions.checkNotNull(fieldConverter);
            return Preconditions.checkNotNull(fieldConverter.zac(obj));
        }

        @NonNull
        public final Object zaf(@NonNull Object obj) {
            FieldConverter fieldConverter = this.f13579c;
            Preconditions.checkNotNull(fieldConverter);
            return fieldConverter.zad(obj);
        }

        @NonNull
        public final Map zah() {
            Preconditions.checkNotNull(this.zah);
            Preconditions.checkNotNull(this.f13578b);
            return (Map) Preconditions.checkNotNull(this.f13578b.zab(this.zah));
        }

        public final void zai(zan zanVar) {
            this.f13578b = zanVar;
        }

        public final boolean zaj() {
            return this.f13579c != null;
        }

        public Field(int i, boolean z, int i2, boolean z2, @NonNull String str, int i3, @Nullable Class cls, @Nullable FieldConverter fieldConverter) {
            this.f13577a = 1;
            this.zaa = i;
            this.zab = z;
            this.zac = i2;
            this.zad = z2;
            this.zae = str;
            this.zaf = i3;
            this.zag = cls;
            if (cls == null) {
                this.zah = null;
            } else {
                this.zah = cls.getCanonicalName();
            }
            this.f13579c = fieldConverter;
        }
    }
}
