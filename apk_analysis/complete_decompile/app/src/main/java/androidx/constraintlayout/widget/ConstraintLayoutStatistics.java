package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.constraintlayout.core.Metrics;
import java.text.DecimalFormat;
import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes.dex */
public class ConstraintLayoutStatistics {
    public static final int DURATION_OF_CHILD_MEASURES = 5;
    public static final int DURATION_OF_LAYOUT = 7;
    public static final int DURATION_OF_MEASURES = 6;
    public static final int NUMBER_OF_CHILD_MEASURES = 4;
    public static final int NUMBER_OF_CHILD_VIEWS = 3;
    public static final int NUMBER_OF_EQUATIONS = 9;
    public static final int NUMBER_OF_LAYOUTS = 1;
    public static final int NUMBER_OF_ON_MEASURES = 2;
    public static final int NUMBER_OF_SIMPLE_EQUATIONS = 10;
    public static final int NUMBER_OF_VARIABLES = 8;

    /* renamed from: c */
    public static final String f3178c = new String(new char[25]).replace((char) 0, ' ');

    /* renamed from: a */
    public final Metrics f3179a;

    /* renamed from: b */
    public ConstraintLayout f3180b;

    public ConstraintLayoutStatistics(ConstraintLayout constraintLayout) {
        this.f3179a = new Metrics();
        attach(constraintLayout);
    }

    /* renamed from: c */
    public static String m634c(DecimalFormat decimalFormat, float f) {
        StringBuilder m7064t = AbstractC1726qj.m7064t(new String(new char[7]).replace((char) 0, ' '));
        m7064t.append(decimalFormat.format(f));
        String sb = m7064t.toString();
        return sb.substring(sb.length() - 7);
    }

    /* renamed from: d */
    public static String m635d(int i) {
        switch (i) {
            case 1:
                return "NumberOfLayouts";
            case 2:
                return "MeasureCalls";
            case 3:
                return "ChildCount";
            case 4:
                return "ChildrenMeasures";
            case 5:
                return "MeasuresWidgetsDuration ";
            case 6:
                return "MeasureDuration";
            case 7:
                return "MeasuresLayoutDuration";
            case 8:
                return "SolverVariables";
            case 9:
                return "SolverEquations";
            case 10:
                return "SimpleEquations";
            default:
                return "";
        }
    }

    /* renamed from: a */
    public final String m636a(ConstraintLayoutStatistics constraintLayoutStatistics, int i) {
        return ye0.m8296p("CL Perf: ", AbstractC1726qj.m7057m(AbstractC1726qj.m7061q(new StringBuilder(), f3178c, m635d(i)).substring(r5.length() - 25), " = "), getValue(i) + " -> " + constraintLayoutStatistics.getValue(i));
    }

    public void attach(ConstraintLayout constraintLayout) {
        constraintLayout.fillMetrics(this.f3179a);
        this.f3180b = constraintLayout;
    }

    /* renamed from: b */
    public final String m637b(DecimalFormat decimalFormat, ConstraintLayoutStatistics constraintLayoutStatistics, int i) {
        StringBuilder m8303w = ye0.m8303w(m634c(decimalFormat, ((float) getValue(i)) * 1.0E-6f), " -> ");
        m8303w.append(m634c(decimalFormat, ((float) constraintLayoutStatistics.getValue(i)) * 1.0E-6f));
        m8303w.append("ms");
        return ye0.m8296p("CL Perf: ", AbstractC1726qj.m7057m(AbstractC1726qj.m7061q(new StringBuilder(), f3178c, m635d(i)).substring(r6.length() - 25), " = "), m8303w.toString());
    }

    public void detach() {
        ConstraintLayout constraintLayout = this.f3180b;
        if (constraintLayout != null) {
            constraintLayout.fillMetrics(null);
        }
    }

    /* renamed from: e */
    public final String m638e(int i) {
        return ye0.m8296p("CL Perf: ", AbstractC1726qj.m7057m(AbstractC1726qj.m7061q(new StringBuilder(), f3178c, m635d(i)).substring(r4.length() - 25), " = "), Long.toString(getValue(i)));
    }

    /* renamed from: f */
    public final String m639f(DecimalFormat decimalFormat, int i) {
        return ye0.m8296p("CL Perf: ", AbstractC1726qj.m7057m(AbstractC1726qj.m7061q(new StringBuilder(), f3178c, m635d(i)).substring(r4.length() - 25), " = "), m634c(decimalFormat, ((float) getValue(i)) * 1.0E-6f));
    }

    /* renamed from: g */
    public final void m640g(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        Log.v(str, "CL Perf: --------  Performance .(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")  ------ ");
        DecimalFormat decimalFormat = new DecimalFormat("###.000");
        Log.v(str, m639f(decimalFormat, 5));
        Log.v(str, m639f(decimalFormat, 7));
        Log.v(str, m639f(decimalFormat, 6));
        Log.v(str, m638e(1));
        Log.v(str, m638e(2));
        Log.v(str, m638e(3));
        Log.v(str, m638e(4));
        Log.v(str, m638e(8));
        Log.v(str, m638e(9));
        Log.v(str, m638e(10));
    }

    public long getValue(int i) {
        int i2;
        Metrics metrics = this.f3179a;
        switch (i) {
            case 1:
                i2 = metrics.mNumberOfLayouts;
                break;
            case 2:
                return metrics.mMeasureCalls;
            case 3:
                return metrics.mChildCount;
            case 4:
                i2 = metrics.mNumberOfMeasures;
                break;
            case 5:
                return metrics.measuresWidgetsDuration;
            case 6:
                return metrics.mMeasureDuration;
            case 7:
                return metrics.measuresLayoutDuration;
            case 8:
                return metrics.mVariables;
            case 9:
                return metrics.mEquations;
            case 10:
                return metrics.mSimpleEquations;
            default:
                return 0L;
        }
        return i2;
    }

    public void logSummary(String str) {
        m640g(str);
    }

    public void reset() {
        this.f3179a.reset();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ConstraintLayoutStatistics m8477clone() {
        return new ConstraintLayoutStatistics(this);
    }

    @SuppressLint({"LogConditional"})
    public void logSummary(String str, ConstraintLayoutStatistics constraintLayoutStatistics) {
        if (constraintLayoutStatistics == null) {
            m640g(str);
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("###.000");
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        Log.v(str, "CL Perf: -=  Performance .(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")  =- ");
        Log.v(str, m637b(decimalFormat, constraintLayoutStatistics, 5));
        Log.v(str, m637b(decimalFormat, constraintLayoutStatistics, 7));
        Log.v(str, m637b(decimalFormat, constraintLayoutStatistics, 6));
        Log.v(str, m636a(constraintLayoutStatistics, 1));
        Log.v(str, m636a(constraintLayoutStatistics, 2));
        Log.v(str, m636a(constraintLayoutStatistics, 3));
        Log.v(str, m636a(constraintLayoutStatistics, 4));
        Log.v(str, m636a(constraintLayoutStatistics, 8));
        Log.v(str, m636a(constraintLayoutStatistics, 9));
        Log.v(str, m636a(constraintLayoutStatistics, 10));
    }

    public ConstraintLayoutStatistics(ConstraintLayoutStatistics constraintLayoutStatistics) {
        Metrics metrics = new Metrics();
        this.f3179a = metrics;
        metrics.copy(constraintLayoutStatistics.f3179a);
    }
}
