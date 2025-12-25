package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1278hq;

@Metadata(m5568d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\n\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0018J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, m5569d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", FirebaseAnalytics.Param.INDEX, "get", "(I)Lokio/ByteString;", "", "a", "[Lokio/ByteString;", "getByteStrings$okio", "()[Lokio/ByteString;", "byteStrings", "", "b", "[I", "getTrie$okio", "()[I", "trie", "getSize", "()I", "size", "Companion", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final ByteString[] byteStrings;

    /* renamed from: b, reason: from kotlin metadata */
    public final int[] trie;

    @Metadata(m5568d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5569d2 = {"Lokio/Options$Companion;", "", "", "Lokio/ByteString;", "byteStrings", "Lokio/Options;", "of", "([Lokio/ByteString;)Lokio/Options;", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static void m6668a(long j, Buffer buffer, int i, List list, int i2, int i3, List list2) {
            int i4;
            int i5;
            int i6;
            int i7;
            Buffer buffer2;
            int i8 = i;
            if (i2 < i3) {
                for (int i9 = i2; i9 < i3; i9++) {
                    if (((ByteString) list.get(i9)).size() < i8) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                }
                ByteString byteString = (ByteString) list.get(i2);
                ByteString byteString2 = (ByteString) list.get(i3 - 1);
                int i10 = -1;
                if (i8 == byteString.size()) {
                    int intValue = ((Number) list2.get(i2)).intValue();
                    int i11 = i2 + 1;
                    ByteString byteString3 = (ByteString) list.get(i11);
                    i4 = i11;
                    i5 = intValue;
                    byteString = byteString3;
                } else {
                    i4 = i2;
                    i5 = -1;
                }
                if (byteString.getByte(i8) != byteString2.getByte(i8)) {
                    int i12 = 1;
                    for (int i13 = i4 + 1; i13 < i3; i13++) {
                        if (((ByteString) list.get(i13 - 1)).getByte(i8) != ((ByteString) list.get(i13)).getByte(i8)) {
                            i12++;
                        }
                    }
                    long j2 = 4;
                    long size = (buffer.size() / j2) + j + 2 + (i12 * 2);
                    buffer.writeInt(i12);
                    buffer.writeInt(i5);
                    for (int i14 = i4; i14 < i3; i14++) {
                        int i15 = ((ByteString) list.get(i14)).getByte(i8);
                        if (i14 == i4 || i15 != ((ByteString) list.get(i14 - 1)).getByte(i8)) {
                            buffer.writeInt(i15 & 255);
                        }
                    }
                    Buffer buffer3 = new Buffer();
                    int i16 = i4;
                    while (i16 < i3) {
                        byte b = ((ByteString) list.get(i16)).getByte(i8);
                        int i17 = i16 + 1;
                        int i18 = i17;
                        while (true) {
                            if (i18 < i3) {
                                if (b != ((ByteString) list.get(i18)).getByte(i8)) {
                                    i6 = i18;
                                    break;
                                }
                                i18++;
                            } else {
                                i6 = i3;
                                break;
                            }
                        }
                        if (i17 == i6 && i8 + 1 == ((ByteString) list.get(i16)).size()) {
                            buffer.writeInt(((Number) list2.get(i16)).intValue());
                            i7 = i6;
                            buffer2 = buffer3;
                        } else {
                            buffer.writeInt(((int) ((buffer3.size() / j2) + size)) * i10);
                            i7 = i6;
                            buffer2 = buffer3;
                            m6668a(size, buffer3, i8 + 1, list, i16, i6, list2);
                        }
                        buffer3 = buffer2;
                        i16 = i7;
                        i10 = -1;
                    }
                    buffer.writeAll(buffer3);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                int i19 = 0;
                for (int i20 = i8; i20 < min && byteString.getByte(i20) == byteString2.getByte(i20); i20++) {
                    i19++;
                }
                long j3 = 4;
                long size2 = (buffer.size() / j3) + j + 2 + i19 + 1;
                buffer.writeInt(-i19);
                buffer.writeInt(i5);
                int i21 = i19 + i8;
                while (i8 < i21) {
                    buffer.writeInt(byteString.getByte(i8) & 255);
                    i8++;
                }
                if (i4 + 1 == i3) {
                    if (i21 == ((ByteString) list.get(i4)).size()) {
                        buffer.writeInt(((Number) list2.get(i4)).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.");
                }
                Buffer buffer4 = new Buffer();
                buffer.writeInt(((int) ((buffer4.size() / j3) + size2)) * (-1));
                m6668a(size2, buffer4, i21, list, i4, i3, list2);
                buffer.writeAll(buffer4);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00d4, code lost:
        
            continue;
         */
        @JvmStatic
        @NotNull
        /* renamed from: of */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Options m6669of(@NotNull ByteString... byteStrings) {
            Intrinsics.checkNotNullParameter(byteStrings, "byteStrings");
            int i = 0;
            if (byteStrings.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, null);
            }
            List mutableList = ArraysKt___ArraysKt.toMutableList(byteStrings);
            AbstractC1278hq.sort(mutableList);
            ArrayList arrayList = new ArrayList(byteStrings.length);
            for (ByteString byteString : byteStrings) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array != null) {
                Integer[] numArr = (Integer[]) array;
                List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Arrays.copyOf(numArr, numArr.length));
                int length = byteStrings.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    mutableListOf.set(CollectionsKt__CollectionsKt.binarySearch$default(mutableList, byteStrings[i2], 0, 0, 6, (Object) null), Integer.valueOf(i3));
                    i2++;
                    i3++;
                }
                if (((ByteString) mutableList.get(0)).size() > 0) {
                    int i4 = 0;
                    while (i4 < mutableList.size()) {
                        ByteString byteString2 = (ByteString) mutableList.get(i4);
                        int i5 = i4 + 1;
                        int i6 = i5;
                        while (i6 < mutableList.size()) {
                            ByteString byteString3 = (ByteString) mutableList.get(i6);
                            if (byteString3.startsWith(byteString2)) {
                                if (byteString3.size() != byteString2.size()) {
                                    if (((Number) mutableListOf.get(i6)).intValue() > ((Number) mutableListOf.get(i4)).intValue()) {
                                        mutableList.remove(i6);
                                        mutableListOf.remove(i6);
                                    } else {
                                        i6++;
                                    }
                                } else {
                                    throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                                }
                            }
                        }
                        i4 = i5;
                    }
                    Buffer buffer = new Buffer();
                    m6668a(0L, buffer, 0, mutableList, 0, mutableList.size(), mutableListOf);
                    int[] iArr = new int[(int) (buffer.size() / 4)];
                    while (!buffer.exhausted()) {
                        iArr[i] = buffer.readInt();
                        i++;
                    }
                    Object[] copyOf = Arrays.copyOf(byteStrings, byteStrings.length);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                    return new Options((ByteString[]) copyOf, iArr, null);
                }
                throw new IllegalArgumentException("the empty byte string is not a supported option");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    public Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    @JvmStatic
    @NotNull
    /* renamed from: of */
    public static final Options m6667of(@NotNull ByteString... byteStringArr) {
        return INSTANCE.m6669of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    @NotNull
    /* renamed from: getByteStrings$okio, reason: from getter */
    public final ByteString[] getByteStrings() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int getF21007c() {
        return this.byteStrings.length;
    }

    @NotNull
    /* renamed from: getTrie$okio, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Options) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    @NotNull
    public ByteString get(int index) {
        return this.byteStrings[index];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Options) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Options) byteString);
    }
}
