package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import p000.ye0;

/* loaded from: classes.dex */
public class TimePicker extends Picker {

    /* renamed from: A */
    public int f6380A;

    /* renamed from: B */
    public String f6381B;

    /* renamed from: q */
    public PickerColumn f6382q;

    /* renamed from: r */
    public PickerColumn f6383r;

    /* renamed from: s */
    public PickerColumn f6384s;

    /* renamed from: t */
    public int f6385t;

    /* renamed from: u */
    public int f6386u;

    /* renamed from: v */
    public int f6387v;

    /* renamed from: w */
    public final PickerUtility$TimeConstant f6388w;

    /* renamed from: x */
    public boolean f6389x;

    /* renamed from: y */
    public int f6390y;

    /* renamed from: z */
    public int f6391z;

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.timePickerStyle);
    }

    /* renamed from: f */
    public final void m1517f() {
        boolean z;
        boolean z2;
        String str;
        String concat;
        int i = 7;
        String bestHourMinutePattern = getBestHourMinutePattern();
        if (TextUtils.equals(bestHourMinutePattern, this.f6381B)) {
            return;
        }
        this.f6381B = bestHourMinutePattern;
        String bestHourMinutePattern2 = getBestHourMinutePattern();
        PickerUtility$TimeConstant pickerUtility$TimeConstant = this.f6388w;
        if (TextUtils.getLayoutDirectionFromLocale(pickerUtility$TimeConstant.locale) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (bestHourMinutePattern2.indexOf(97) < 0 || bestHourMinutePattern2.indexOf("a") > bestHourMinutePattern2.indexOf("m")) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            str = "mh";
        } else {
            str = "hm";
        }
        if (!is24Hour()) {
            if (z2) {
                concat = str.concat("a");
            } else {
                concat = "a".concat(str);
            }
            str = concat;
        }
        String bestHourMinutePattern3 = getBestHourMinutePattern();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] cArr = {'H', 'h', 'K', 'k', 'm', 'M', 'a'};
        int i2 = 0;
        boolean z3 = false;
        char c = 0;
        while (i2 < bestHourMinutePattern3.length()) {
            char charAt = bestHourMinutePattern3.charAt(i2);
            if (charAt != ' ') {
                if (charAt == '\'') {
                    if (!z3) {
                        sb.setLength(0);
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                } else {
                    if (z3) {
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
                                    i = 7;
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
            i = 7;
        }
        arrayList.add(sb.toString());
        if (arrayList.size() == str.length() + 1) {
            setSeparators(arrayList);
            String upperCase = str.toUpperCase(pickerUtility$TimeConstant.locale);
            this.f6384s = null;
            this.f6383r = null;
            this.f6382q = null;
            this.f6387v = -1;
            this.f6386u = -1;
            this.f6385t = -1;
            ArrayList arrayList2 = new ArrayList(3);
            for (int i4 = 0; i4 < upperCase.length(); i4++) {
                char charAt2 = upperCase.charAt(i4);
                if (charAt2 != 'A') {
                    if (charAt2 != 'H') {
                        if (charAt2 == 'M') {
                            PickerColumn pickerColumn = new PickerColumn();
                            this.f6383r = pickerColumn;
                            arrayList2.add(pickerColumn);
                            this.f6383r.setStaticLabels(pickerUtility$TimeConstant.minutes);
                            this.f6386u = i4;
                        } else {
                            throw new IllegalArgumentException("Invalid time picker format.");
                        }
                    } else {
                        PickerColumn pickerColumn2 = new PickerColumn();
                        this.f6382q = pickerColumn2;
                        arrayList2.add(pickerColumn2);
                        this.f6382q.setStaticLabels(pickerUtility$TimeConstant.hours24);
                        this.f6385t = i4;
                    }
                } else {
                    PickerColumn pickerColumn3 = new PickerColumn();
                    this.f6384s = pickerColumn3;
                    arrayList2.add(pickerColumn3);
                    this.f6384s.setStaticLabels(pickerUtility$TimeConstant.ampm);
                    this.f6387v = i4;
                    PickerColumn pickerColumn4 = this.f6384s;
                    if (pickerColumn4.getMinValue() != 0) {
                        pickerColumn4.setMinValue(0);
                    }
                    PickerColumn pickerColumn5 = this.f6384s;
                    if (1 != pickerColumn5.getMaxValue()) {
                        pickerColumn5.setMaxValue(1);
                    }
                }
            }
            setColumns(arrayList2);
            return;
        }
        throw new IllegalStateException("Separators size: " + arrayList.size() + " must equal the size of timeFieldsPattern: " + str.length() + " + 1");
    }

    /* renamed from: g */
    public final void m1518g() {
        int i;
        PickerColumn pickerColumn = this.f6382q;
        int i2 = !this.f6389x ? 1 : 0;
        if (i2 != pickerColumn.getMinValue()) {
            pickerColumn.setMinValue(i2);
        }
        PickerColumn pickerColumn2 = this.f6382q;
        if (this.f6389x) {
            i = 23;
        } else {
            i = 12;
        }
        if (i != pickerColumn2.getMaxValue()) {
            pickerColumn2.setMaxValue(i);
        }
        PickerColumn pickerColumn3 = this.f6383r;
        if (pickerColumn3.getMinValue() != 0) {
            pickerColumn3.setMinValue(0);
        }
        PickerColumn pickerColumn4 = this.f6383r;
        if (59 != pickerColumn4.getMaxValue()) {
            pickerColumn4.setMaxValue(59);
        }
        PickerColumn pickerColumn5 = this.f6384s;
        if (pickerColumn5 != null) {
            if (pickerColumn5.getMinValue() != 0) {
                pickerColumn5.setMinValue(0);
            }
            PickerColumn pickerColumn6 = this.f6384s;
            if (1 != pickerColumn6.getMaxValue()) {
                pickerColumn6.setMaxValue(1);
            }
        }
    }

    public String getBestHourMinutePattern() {
        String str;
        Locale locale = this.f6388w.locale;
        if (this.f6389x) {
            str = "Hma";
        } else {
            str = "hma";
        }
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(locale, str);
        if (TextUtils.isEmpty(bestDateTimePattern)) {
            return "h:mma";
        }
        return bestDateTimePattern;
    }

    public int getHour() {
        if (this.f6389x) {
            return this.f6390y;
        }
        if (this.f6380A == 0) {
            return this.f6390y % 12;
        }
        return (this.f6390y % 12) + 12;
    }

    public int getMinute() {
        return this.f6391z;
    }

    public boolean is24Hour() {
        return this.f6389x;
    }

    public boolean isPm() {
        if (this.f6380A == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.leanback.widget.picker.Picker
    public void onColumnValueChanged(int i, int i2) {
        if (i == this.f6385t) {
            this.f6390y = i2;
        } else if (i == this.f6386u) {
            this.f6391z = i2;
        } else {
            if (i == this.f6387v) {
                this.f6380A = i2;
                return;
            }
            throw new IllegalArgumentException("Invalid column index.");
        }
    }

    public void setHour(@IntRange(from = 0, m153to = 23) int i) {
        if (i >= 0 && i <= 23) {
            this.f6390y = i;
            if (!is24Hour()) {
                int i2 = this.f6390y;
                if (i2 >= 12) {
                    this.f6380A = 1;
                    if (i2 > 12) {
                        this.f6390y = i2 - 12;
                    }
                } else {
                    this.f6380A = 0;
                    if (i2 == 0) {
                        this.f6390y = 12;
                    }
                }
                if (!is24Hour()) {
                    setColumnValue(this.f6387v, this.f6380A, false);
                }
            }
            setColumnValue(this.f6385t, this.f6390y, false);
            return;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "hour: ", " is not in [0-23] range in"));
    }

    public void setIs24Hour(boolean z) {
        if (this.f6389x == z) {
            return;
        }
        int hour = getHour();
        int minute = getMinute();
        this.f6389x = z;
        m1517f();
        m1518g();
        setHour(hour);
        setMinute(minute);
        if (!is24Hour()) {
            setColumnValue(this.f6387v, this.f6380A, false);
        }
    }

    public void setMinute(@IntRange(from = 0, m153to = 59) int i) {
        if (i >= 0 && i <= 59) {
            this.f6391z = i;
            setColumnValue(this.f6386u, i, false);
            return;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "minute: ", " is not in [0-59] range."));
    }

    @SuppressLint({"CustomViewStyleable"})
    public TimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Locale locale = Locale.getDefault();
        context.getResources();
        PickerUtility$TimeConstant pickerUtility$TimeConstant = new PickerUtility$TimeConstant(locale);
        this.f6388w = pickerUtility$TimeConstant;
        int[] iArr = R.styleable.lbTimePicker;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        try {
            this.f6389x = obtainStyledAttributes.getBoolean(R.styleable.lbTimePicker_is24HourFormat, DateFormat.is24HourFormat(context));
            boolean z = obtainStyledAttributes.getBoolean(R.styleable.lbTimePicker_useCurrentTime, true);
            obtainStyledAttributes.recycle();
            m1517f();
            m1518g();
            if (z) {
                Calendar calendar = Calendar.getInstance(pickerUtility$TimeConstant.locale);
                setHour(calendar.get(11));
                setMinute(calendar.get(12));
                if (is24Hour()) {
                    return;
                }
                setColumnValue(this.f6387v, this.f6380A, false);
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
