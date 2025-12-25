package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import p000.RunnableC1889uy;
import p000.p63;

/* loaded from: classes.dex */
public class DatePicker extends Picker {

    /* renamed from: D */
    public static final int[] f6345D = {5, 2, 1};

    /* renamed from: A */
    public final Calendar f6346A;

    /* renamed from: B */
    public final Calendar f6347B;

    /* renamed from: C */
    public final Calendar f6348C;

    /* renamed from: q */
    public String f6349q;

    /* renamed from: r */
    public PickerColumn f6350r;

    /* renamed from: s */
    public PickerColumn f6351s;

    /* renamed from: t */
    public PickerColumn f6352t;

    /* renamed from: u */
    public int f6353u;

    /* renamed from: v */
    public int f6354v;

    /* renamed from: w */
    public int f6355w;

    /* renamed from: x */
    public final SimpleDateFormat f6356x;

    /* renamed from: y */
    public final PickerUtility$DateConstant f6357y;

    /* renamed from: z */
    public final Calendar f6358z;

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    /* renamed from: f */
    public final boolean m1511f(String str, Calendar calendar) {
        try {
            calendar.setTime(this.f6356x.parse(str));
            return true;
        } catch (ParseException unused) {
            Log.w("DatePicker", "Date: " + str + " not in format: MM/dd/yyyy");
            return false;
        }
    }

    public long getDate() {
        return this.f6347B.getTimeInMillis();
    }

    public String getDatePickerFormat() {
        return this.f6349q;
    }

    public long getMaxDate() {
        return this.f6346A.getTimeInMillis();
    }

    public long getMinDate() {
        return this.f6358z.getTimeInMillis();
    }

    @Override // androidx.leanback.widget.picker.Picker
    public final void onColumnValueChanged(int i, int i2) {
        this.f6348C.setTimeInMillis(this.f6347B.getTimeInMillis());
        int currentValue = getColumnAt(i).getCurrentValue();
        if (i == this.f6354v) {
            this.f6348C.add(5, i2 - currentValue);
        } else if (i == this.f6353u) {
            this.f6348C.add(2, i2 - currentValue);
        } else if (i == this.f6355w) {
            this.f6348C.add(1, i2 - currentValue);
        } else {
            throw new IllegalArgumentException();
        }
        setDate(this.f6348C.get(1), this.f6348C.get(2), this.f6348C.get(5), false);
    }

    public void setDate(long j) {
        this.f6348C.setTimeInMillis(j);
        setDate(this.f6348C.get(1), this.f6348C.get(2), this.f6348C.get(5), false);
    }

    public void setDatePickerFormat(String str) {
        String str2;
        int i = 6;
        PickerUtility$DateConstant pickerUtility$DateConstant = this.f6357y;
        if (TextUtils.isEmpty(str)) {
            str2 = new String(DateFormat.getDateFormatOrder(getContext()));
        } else {
            str2 = str;
        }
        if (TextUtils.equals(this.f6349q, str2)) {
            return;
        }
        this.f6349q = str2;
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(pickerUtility$DateConstant.locale, str2);
        if (TextUtils.isEmpty(bestDateTimePattern)) {
            bestDateTimePattern = "MM/dd/yyyy";
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] cArr = {'Y', 'y', 'M', 'm', 'D', 'd'};
        int i2 = 0;
        boolean z = false;
        char c = 0;
        while (i2 < bestDateTimePattern.length()) {
            char charAt = bestDateTimePattern.charAt(i2);
            if (charAt != ' ') {
                if (charAt == '\'') {
                    if (!z) {
                        sb.setLength(0);
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    if (z) {
                        sb.append(charAt);
                    } else {
                        int i3 = 0;
                        while (true) {
                            if (i3 < i) {
                                if (charAt == cArr[i3]) {
                                    if (charAt != c) {
                                        arrayList.add(sb.toString());
                                        sb.setLength(0);
                                    }
                                } else {
                                    i3++;
                                    i = 6;
                                }
                            } else {
                                sb.append(charAt);
                                break;
                            }
                        }
                    }
                    c = charAt;
                }
            }
            i2++;
            i = 6;
        }
        arrayList.add(sb.toString());
        if (arrayList.size() == str2.length() + 1) {
            setSeparators(arrayList);
            this.f6351s = null;
            this.f6350r = null;
            this.f6352t = null;
            this.f6353u = -1;
            this.f6354v = -1;
            this.f6355w = -1;
            String upperCase = str2.toUpperCase(pickerUtility$DateConstant.locale);
            ArrayList arrayList2 = new ArrayList(3);
            for (int i4 = 0; i4 < upperCase.length(); i4++) {
                char charAt2 = upperCase.charAt(i4);
                if (charAt2 != 'D') {
                    if (charAt2 != 'M') {
                        if (charAt2 == 'Y') {
                            if (this.f6352t == null) {
                                PickerColumn pickerColumn = new PickerColumn();
                                this.f6352t = pickerColumn;
                                arrayList2.add(pickerColumn);
                                this.f6355w = i4;
                                this.f6352t.setLabelFormat("%d");
                            } else {
                                throw new IllegalArgumentException("datePicker format error");
                            }
                        } else {
                            throw new IllegalArgumentException("datePicker format error");
                        }
                    } else if (this.f6350r == null) {
                        PickerColumn pickerColumn2 = new PickerColumn();
                        this.f6350r = pickerColumn2;
                        arrayList2.add(pickerColumn2);
                        this.f6350r.setStaticLabels(pickerUtility$DateConstant.months);
                        this.f6353u = i4;
                    } else {
                        throw new IllegalArgumentException("datePicker format error");
                    }
                } else if (this.f6351s == null) {
                    PickerColumn pickerColumn3 = new PickerColumn();
                    this.f6351s = pickerColumn3;
                    arrayList2.add(pickerColumn3);
                    this.f6351s.setLabelFormat("%02d");
                    this.f6354v = i4;
                } else {
                    throw new IllegalArgumentException("datePicker format error");
                }
            }
            setColumns(arrayList2);
            post(new RunnableC1889uy(this, 0, false));
            return;
        }
        throw new IllegalStateException("Separators size: " + arrayList.size() + " must equal the size of datePickerFormat: " + str2.length() + " + 1");
    }

    public void setMaxDate(long j) {
        this.f6348C.setTimeInMillis(j);
        if (this.f6348C.get(1) == this.f6346A.get(1) && this.f6348C.get(6) != this.f6346A.get(6)) {
            return;
        }
        this.f6346A.setTimeInMillis(j);
        if (this.f6347B.after(this.f6346A)) {
            this.f6347B.setTimeInMillis(this.f6346A.getTimeInMillis());
        }
        post(new RunnableC1889uy(this, 0, false));
    }

    public void setMinDate(long j) {
        this.f6348C.setTimeInMillis(j);
        if (this.f6348C.get(1) == this.f6358z.get(1) && this.f6348C.get(6) != this.f6358z.get(6)) {
            return;
        }
        this.f6358z.setTimeInMillis(j);
        if (this.f6347B.before(this.f6358z)) {
            this.f6347B.setTimeInMillis(this.f6358z.getTimeInMillis());
        }
        post(new RunnableC1889uy(this, 0, false));
    }

    @SuppressLint({"CustomViewStyleable"})
    public DatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6356x = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        Locale locale = Locale.getDefault();
        getContext().getResources();
        PickerUtility$DateConstant pickerUtility$DateConstant = new PickerUtility$DateConstant(locale);
        this.f6357y = pickerUtility$DateConstant;
        this.f6348C = p63.m6842B(this.f6348C, pickerUtility$DateConstant.locale);
        this.f6358z = p63.m6842B(this.f6358z, this.f6357y.locale);
        this.f6346A = p63.m6842B(this.f6346A, this.f6357y.locale);
        this.f6347B = p63.m6842B(this.f6347B, this.f6357y.locale);
        PickerColumn pickerColumn = this.f6350r;
        if (pickerColumn != null) {
            pickerColumn.setStaticLabels(this.f6357y.months);
            setColumnAt(this.f6353u, this.f6350r);
        }
        int[] iArr = R.styleable.lbDatePicker;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        try {
            String string = obtainStyledAttributes.getString(R.styleable.lbDatePicker_android_minDate);
            String string2 = obtainStyledAttributes.getString(R.styleable.lbDatePicker_android_maxDate);
            String string3 = obtainStyledAttributes.getString(R.styleable.lbDatePicker_datePickerFormat);
            obtainStyledAttributes.recycle();
            this.f6348C.clear();
            if (!TextUtils.isEmpty(string)) {
                if (!m1511f(string, this.f6348C)) {
                    this.f6348C.set(1900, 0, 1);
                }
            } else {
                this.f6348C.set(1900, 0, 1);
            }
            this.f6358z.setTimeInMillis(this.f6348C.getTimeInMillis());
            this.f6348C.clear();
            if (!TextUtils.isEmpty(string2)) {
                if (!m1511f(string2, this.f6348C)) {
                    this.f6348C.set(2100, 0, 1);
                }
            } else {
                this.f6348C.set(2100, 0, 1);
            }
            this.f6346A.setTimeInMillis(this.f6348C.getTimeInMillis());
            setDatePickerFormat(TextUtils.isEmpty(string3) ? new String(DateFormat.getDateFormatOrder(context)) : string3);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setDate(int i, int i2, int i3, boolean z) {
        if (this.f6347B.get(1) == i && this.f6347B.get(2) == i3 && this.f6347B.get(5) == i2) {
            return;
        }
        this.f6347B.set(i, i2, i3);
        if (this.f6347B.before(this.f6358z)) {
            this.f6347B.setTimeInMillis(this.f6358z.getTimeInMillis());
        } else if (this.f6347B.after(this.f6346A)) {
            this.f6347B.setTimeInMillis(this.f6346A.getTimeInMillis());
        }
        post(new RunnableC1889uy(this, 0, z));
    }
}
