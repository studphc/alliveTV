package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;

@Metadata(m5568d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a)\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0007\u001a'\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a2\u0010\t\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0080\b¢\u0006\u0004\b\t\u0010\u000e\u001a(\u0010\u0010\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000f\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b\u0010\u0010\n\u001a0\u0010\u0012\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u0014\u0010\u0007\u001a8\u0010\u0014\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u0014\u0010\u0017\u001a0\u0010\u0018\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a0\u0010\u001b\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u001d\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u001d\u0010\u0007\u001a \u0010\u001e\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a \u0010 \u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b \u0010!\u001a(\u0010\"\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000f\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b\"\u0010#\u001a(\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000f\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b$\u0010\u0005\u001a0\u0010%\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b%\u0010\u0019\u001a(\u0010&\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b&\u0010#\u001a(\u0010'\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b'\u0010(\u001a(\u0010)\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b)\u0010*\u001a(\u0010+\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b+\u0010,\u001a \u0010-\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b-\u0010.\u001a0\u0010/\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b/\u0010\u0019\u001a \u00101\u001a\u000200\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b1\u00102¨\u00063"}, m5569d2 = {ExifInterface.LONGITUDE_EAST, "Landroidx/collection/SparseArrayCompat;", "", "key", "commonGet", "(Landroidx/collection/SparseArrayCompat;I)Ljava/lang/Object;", "defaultValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "", "commonRemove", "(Landroidx/collection/SparseArrayCompat;I)V", "", "value", "", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Z", FirebaseAnalytics.Param.INDEX, "commonRemoveAt", "size", "commonRemoveAtRange", "(Landroidx/collection/SparseArrayCompat;II)V", "commonReplace", "oldValue", "newValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;Ljava/lang/Object;)Z", "commonPut", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "other", "commonPutAll", "(Landroidx/collection/SparseArrayCompat;Landroidx/collection/SparseArrayCompat;)V", "commonPutIfAbsent", "commonSize", "(Landroidx/collection/SparseArrayCompat;)I", "commonIsEmpty", "(Landroidx/collection/SparseArrayCompat;)Z", "commonKeyAt", "(Landroidx/collection/SparseArrayCompat;I)I", "commonValueAt", "commonSetValueAt", "commonIndexOfKey", "commonIndexOfValue", "(Landroidx/collection/SparseArrayCompat;Ljava/lang/Object;)I", "commonContainsKey", "(Landroidx/collection/SparseArrayCompat;I)Z", "commonContainsValue", "(Landroidx/collection/SparseArrayCompat;Ljava/lang/Object;)Z", "commonClear", "(Landroidx/collection/SparseArrayCompat;)V", "commonAppend", "", "commonToString", "(Landroidx/collection/SparseArrayCompat;)Ljava/lang/String;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSparseArrayCompat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseArrayCompat.kt\nandroidx/collection/SparseArrayCompatKt\n*L\n1#1,535:1\n244#1,6:536\n244#1,6:542\n353#1,40:548\n353#1,40:588\n459#1,9:628\n*S KotlinDebug\n*F\n+ 1 SparseArrayCompat.kt\nandroidx/collection/SparseArrayCompatKt\n*L\n255#1:536,6\n260#1:542,6\n397#1:548,40\n405#1:588,40\n477#1:628,9\n*E\n"})
/* loaded from: classes.dex */
public final class SparseArrayCompatKt {

    /* renamed from: a */
    public static final Object f1756a = new Object();

    public static final void access$gc(SparseArrayCompat sparseArrayCompat) {
        int i = sparseArrayCompat.size;
        int[] iArr = sparseArrayCompat.keys;
        Object[] objArr = sparseArrayCompat.values;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1756a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        sparseArrayCompat.garbage = false;
        sparseArrayCompat.size = i2;
    }

    public static final <E> void commonAppend(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int i2 = sparseArrayCompat.size;
        if (i2 != 0 && i <= sparseArrayCompat.keys[i2 - 1]) {
            sparseArrayCompat.put(i, e);
            return;
        }
        if (sparseArrayCompat.garbage && i2 >= sparseArrayCompat.keys.length) {
            access$gc(sparseArrayCompat);
        }
        int i3 = sparseArrayCompat.size;
        if (i3 >= sparseArrayCompat.keys.length) {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i3 + 1);
            int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            sparseArrayCompat.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            sparseArrayCompat.values = copyOf2;
        }
        sparseArrayCompat.keys[i3] = i;
        sparseArrayCompat.values[i3] = e;
        sparseArrayCompat.size = i3 + 1;
    }

    public static final <E> void commonClear(@NotNull SparseArrayCompat<E> sparseArrayCompat) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int i = sparseArrayCompat.size;
        Object[] objArr = sparseArrayCompat.values;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        sparseArrayCompat.size = 0;
        sparseArrayCompat.garbage = false;
    }

    public static final <E> boolean commonContainsKey(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final <E> boolean commonContainsValue(@NotNull SparseArrayCompat<E> sparseArrayCompat, E e) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            access$gc(sparseArrayCompat);
        }
        int i = sparseArrayCompat.size;
        int i2 = 0;
        while (true) {
            if (i2 < i) {
                if (sparseArrayCompat.values[i2] == e) {
                    break;
                }
                i2++;
            } else {
                i2 = -1;
                break;
            }
        }
        if (i2 < 0) {
            return false;
        }
        return true;
    }

    @Nullable
    public static final <E> E commonGet(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i) {
        E e;
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        if (binarySearch < 0 || (e = (E) sparseArrayCompat.values[binarySearch]) == f1756a) {
            return null;
        }
        return e;
    }

    public static final <E> int commonIndexOfKey(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            access$gc(sparseArrayCompat);
        }
        return ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
    }

    public static final <E> int commonIndexOfValue(@NotNull SparseArrayCompat<E> sparseArrayCompat, E e) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            access$gc(sparseArrayCompat);
        }
        int i = sparseArrayCompat.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (sparseArrayCompat.values[i2] == e) {
                return i2;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(@NotNull SparseArrayCompat<E> sparseArrayCompat) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <E> int commonKeyAt(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            access$gc(sparseArrayCompat);
        }
        return sparseArrayCompat.keys[i];
    }

    public static final <E> void commonPut(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        if (binarySearch >= 0) {
            sparseArrayCompat.values[binarySearch] = e;
            return;
        }
        int i2 = ~binarySearch;
        if (i2 < sparseArrayCompat.size && sparseArrayCompat.values[i2] == f1756a) {
            sparseArrayCompat.keys[i2] = i;
            sparseArrayCompat.values[i2] = e;
            return;
        }
        if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
            access$gc(sparseArrayCompat);
            i2 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        }
        int i3 = sparseArrayCompat.size;
        if (i3 >= sparseArrayCompat.keys.length) {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i3 + 1);
            int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            sparseArrayCompat.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            sparseArrayCompat.values = copyOf2;
        }
        int i4 = sparseArrayCompat.size;
        if (i4 - i2 != 0) {
            int[] iArr = sparseArrayCompat.keys;
            int i5 = i2 + 1;
            ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i5, i2, i4);
            Object[] objArr = sparseArrayCompat.values;
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i5, i2, sparseArrayCompat.size);
        }
        sparseArrayCompat.keys[i2] = i;
        sparseArrayCompat.values[i2] = e;
        sparseArrayCompat.size++;
    }

    public static final <E> void commonPutAll(@NotNull SparseArrayCompat<E> sparseArrayCompat, @NotNull SparseArrayCompat<? extends E> other) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            int keyAt = other.keyAt(i);
            E valueAt = other.valueAt(i);
            int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, keyAt);
            if (binarySearch >= 0) {
                sparseArrayCompat.values[binarySearch] = valueAt;
            } else {
                int i2 = ~binarySearch;
                if (i2 < sparseArrayCompat.size && sparseArrayCompat.values[i2] == f1756a) {
                    sparseArrayCompat.keys[i2] = keyAt;
                    sparseArrayCompat.values[i2] = valueAt;
                } else {
                    if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                        access$gc(sparseArrayCompat);
                        i2 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, keyAt);
                    }
                    int i3 = sparseArrayCompat.size;
                    if (i3 >= sparseArrayCompat.keys.length) {
                        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i3 + 1);
                        int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                        sparseArrayCompat.keys = copyOf;
                        Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
                        sparseArrayCompat.values = copyOf2;
                    }
                    int i4 = sparseArrayCompat.size;
                    if (i4 - i2 != 0) {
                        int[] iArr = sparseArrayCompat.keys;
                        int i5 = i2 + 1;
                        ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i5, i2, i4);
                        Object[] objArr = sparseArrayCompat.values;
                        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i5, i2, sparseArrayCompat.size);
                    }
                    sparseArrayCompat.keys[i2] = keyAt;
                    sparseArrayCompat.values[i2] = valueAt;
                    sparseArrayCompat.size++;
                }
            }
        }
    }

    @Nullable
    public static final <E> E commonPutIfAbsent(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        E e2 = (E) commonGet(sparseArrayCompat, i);
        if (e2 == null) {
            int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
            if (binarySearch >= 0) {
                sparseArrayCompat.values[binarySearch] = e;
            } else {
                int i2 = ~binarySearch;
                if (i2 < sparseArrayCompat.size && sparseArrayCompat.values[i2] == f1756a) {
                    sparseArrayCompat.keys[i2] = i;
                    sparseArrayCompat.values[i2] = e;
                } else {
                    if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                        access$gc(sparseArrayCompat);
                        i2 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
                    }
                    int i3 = sparseArrayCompat.size;
                    if (i3 >= sparseArrayCompat.keys.length) {
                        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i3 + 1);
                        int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                        sparseArrayCompat.keys = copyOf;
                        Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
                        sparseArrayCompat.values = copyOf2;
                    }
                    int i4 = sparseArrayCompat.size;
                    if (i4 - i2 != 0) {
                        int[] iArr = sparseArrayCompat.keys;
                        int i5 = i2 + 1;
                        ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i5, i2, i4);
                        Object[] objArr = sparseArrayCompat.values;
                        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i5, i2, sparseArrayCompat.size);
                    }
                    sparseArrayCompat.keys[i2] = i;
                    sparseArrayCompat.values[i2] = e;
                    sparseArrayCompat.size++;
                }
            }
        }
        return e2;
    }

    public static final <E> void commonRemove(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        if (binarySearch >= 0) {
            Object[] objArr = sparseArrayCompat.values;
            Object obj = objArr[binarySearch];
            Object obj2 = f1756a;
            if (obj != obj2) {
                objArr[binarySearch] = obj2;
                sparseArrayCompat.garbage = true;
            }
        }
    }

    public static final <E> void commonRemoveAt(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.values[i] != f1756a) {
            sparseArrayCompat.values[i] = f1756a;
            sparseArrayCompat.garbage = true;
        }
    }

    public static final <E> void commonRemoveAtRange(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i, int i2) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int min = Math.min(i2, i + i2);
        while (i < min) {
            sparseArrayCompat.removeAt(i);
            i++;
        }
    }

    @Nullable
    public static final <E> E commonReplace(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int indexOfKey = sparseArrayCompat.indexOfKey(i);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = sparseArrayCompat.values;
        E e2 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e;
        return e2;
    }

    public static final <E> void commonSetValueAt(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            access$gc(sparseArrayCompat);
        }
        sparseArrayCompat.values[i] = e;
    }

    public static final <E> int commonSize(@NotNull SparseArrayCompat<E> sparseArrayCompat) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            access$gc(sparseArrayCompat);
        }
        return sparseArrayCompat.size;
    }

    @NotNull
    public static final <E> String commonToString(@NotNull SparseArrayCompat<E> sparseArrayCompat) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(sparseArrayCompat.size * 28);
        sb.append('{');
        int i = sparseArrayCompat.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(sparseArrayCompat.keyAt(i2));
            sb.append('=');
            E valueAt = sparseArrayCompat.valueAt(i2);
            if (valueAt != sparseArrayCompat) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return AbstractC1726qj.m7060p(sb, '}', "buffer.toString()");
    }

    public static final <E> E commonValueAt(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            access$gc(sparseArrayCompat);
        }
        return (E) sparseArrayCompat.values[i];
    }

    public static final <E> E commonGet(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        E e2;
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        return (binarySearch < 0 || (e2 = (E) sparseArrayCompat.values[binarySearch]) == f1756a) ? e : e2;
    }

    public static final <E> boolean commonReplace(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i, E e, E e2) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int indexOfKey = sparseArrayCompat.indexOfKey(i);
        if (indexOfKey < 0 || !Intrinsics.areEqual(sparseArrayCompat.values[indexOfKey], e)) {
            return false;
        }
        sparseArrayCompat.values[indexOfKey] = e2;
        return true;
    }

    public static final <E> boolean commonRemove(@NotNull SparseArrayCompat<E> sparseArrayCompat, int i, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int indexOfKey = sparseArrayCompat.indexOfKey(i);
        if (indexOfKey < 0 || !Intrinsics.areEqual(obj, sparseArrayCompat.valueAt(indexOfKey))) {
            return false;
        }
        sparseArrayCompat.removeAt(indexOfKey);
        return true;
    }
}
