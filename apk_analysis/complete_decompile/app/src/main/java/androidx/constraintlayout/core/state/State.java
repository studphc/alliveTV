package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.constraintlayout.core.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.core.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.FlowReference;
import androidx.constraintlayout.core.state.helpers.GridReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.constraintlayout.core.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.core.state.helpers.VerticalChainReference;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p000.ye0;

/* loaded from: classes.dex */
public class State {
    public static final Integer PARENT = 0;

    /* renamed from: a */
    public CorePixelDp f2350a;

    /* renamed from: d */
    public int f2353d;

    /* renamed from: e */
    public final ArrayList f2354e;

    /* renamed from: f */
    public final ArrayList f2355f;

    /* renamed from: g */
    public boolean f2356g;
    public final ConstraintReference mParent;

    /* renamed from: b */
    public boolean f2351b = true;
    protected HashMap<Object, Reference> mReferences = new HashMap<>();
    protected HashMap<Object, HelperReference> mHelperReferences = new HashMap<>();

    /* renamed from: c */
    public final HashMap f2352c = new HashMap();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Chain {
        public static final Chain PACKED;
        public static final Chain SPREAD;
        public static final Chain SPREAD_INSIDE;

        /* renamed from: a */
        public static final /* synthetic */ Chain[] f2357a;
        public static Map<String, Chain> chainMap;
        public static Map<String, Integer> valueMap;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Chain, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Chain, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Chain, java.lang.Object] */
        static {
            ?? r3 = new Enum("SPREAD", 0);
            SPREAD = r3;
            ?? r4 = new Enum("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r4;
            ?? r5 = new Enum("PACKED", 2);
            PACKED = r5;
            f2357a = new Chain[]{r3, r4, r5};
            chainMap = new HashMap();
            valueMap = new HashMap();
            chainMap.put("packed", r5);
            chainMap.put("spread_inside", r4);
            chainMap.put("spread", r3);
            valueMap.put("packed", 2);
            valueMap.put("spread_inside", 1);
            valueMap.put("spread", 0);
        }

        public static Chain getChainByString(String str) {
            if (chainMap.containsKey(str)) {
                return chainMap.get(str);
            }
            return null;
        }

        public static int getValueByString(String str) {
            if (valueMap.containsKey(str)) {
                return valueMap.get(str).intValue();
            }
            return -1;
        }

        public static Chain valueOf(String str) {
            return (Chain) Enum.valueOf(Chain.class, str);
        }

        public static Chain[] values() {
            return (Chain[]) f2357a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Constraint {
        public static final Constraint BASELINE_TO_BASELINE;
        public static final Constraint BASELINE_TO_BOTTOM;
        public static final Constraint BASELINE_TO_TOP;
        public static final Constraint BOTTOM_TO_BASELINE;
        public static final Constraint BOTTOM_TO_BOTTOM;
        public static final Constraint BOTTOM_TO_TOP;
        public static final Constraint CENTER_HORIZONTALLY;
        public static final Constraint CENTER_VERTICALLY;
        public static final Constraint CIRCULAR_CONSTRAINT;
        public static final Constraint END_TO_END;
        public static final Constraint END_TO_START;
        public static final Constraint LEFT_TO_LEFT;
        public static final Constraint LEFT_TO_RIGHT;
        public static final Constraint RIGHT_TO_LEFT;
        public static final Constraint RIGHT_TO_RIGHT;
        public static final Constraint START_TO_END;
        public static final Constraint START_TO_START;
        public static final Constraint TOP_TO_BASELINE;
        public static final Constraint TOP_TO_BOTTOM;
        public static final Constraint TOP_TO_TOP;

        /* renamed from: a */
        public static final /* synthetic */ Constraint[] f2358a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Constraint] */
        static {
            ?? r4 = new Enum("LEFT_TO_LEFT", 0);
            LEFT_TO_LEFT = r4;
            ?? r5 = new Enum("LEFT_TO_RIGHT", 1);
            LEFT_TO_RIGHT = r5;
            ?? r3 = new Enum("RIGHT_TO_LEFT", 2);
            RIGHT_TO_LEFT = r3;
            ?? r2 = new Enum("RIGHT_TO_RIGHT", 3);
            RIGHT_TO_RIGHT = r2;
            ?? r1 = new Enum("START_TO_START", 4);
            START_TO_START = r1;
            ?? r0 = new Enum("START_TO_END", 5);
            START_TO_END = r0;
            ?? r15 = new Enum("END_TO_START", 6);
            END_TO_START = r15;
            ?? r14 = new Enum("END_TO_END", 7);
            END_TO_END = r14;
            ?? r13 = new Enum("TOP_TO_TOP", 8);
            TOP_TO_TOP = r13;
            ?? r12 = new Enum("TOP_TO_BOTTOM", 9);
            TOP_TO_BOTTOM = r12;
            ?? r11 = new Enum("TOP_TO_BASELINE", 10);
            TOP_TO_BASELINE = r11;
            ?? r10 = new Enum("BOTTOM_TO_TOP", 11);
            BOTTOM_TO_TOP = r10;
            ?? r9 = new Enum("BOTTOM_TO_BOTTOM", 12);
            BOTTOM_TO_BOTTOM = r9;
            ?? r8 = new Enum("BOTTOM_TO_BASELINE", 13);
            BOTTOM_TO_BASELINE = r8;
            ?? r7 = new Enum("BASELINE_TO_BASELINE", 14);
            BASELINE_TO_BASELINE = r7;
            ?? r6 = new Enum("BASELINE_TO_TOP", 15);
            BASELINE_TO_TOP = r6;
            ?? r72 = new Enum("BASELINE_TO_BOTTOM", 16);
            BASELINE_TO_BOTTOM = r72;
            ?? r62 = new Enum("CENTER_HORIZONTALLY", 17);
            CENTER_HORIZONTALLY = r62;
            ?? r73 = new Enum("CENTER_VERTICALLY", 18);
            CENTER_VERTICALLY = r73;
            ?? r63 = new Enum("CIRCULAR_CONSTRAINT", 19);
            CIRCULAR_CONSTRAINT = r63;
            f2358a = new Constraint[]{r4, r5, r3, r2, r1, r0, r15, r14, r13, r12, r11, r10, r9, r8, r7, r6, r72, r62, r73, r63};
        }

        public static Constraint valueOf(String str) {
            return (Constraint) Enum.valueOf(Constraint.class, str);
        }

        public static Constraint[] values() {
            return (Constraint[]) f2358a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Direction {
        public static final Direction BOTTOM;
        public static final Direction END;
        public static final Direction LEFT;
        public static final Direction RIGHT;
        public static final Direction START;
        public static final Direction TOP;

        /* renamed from: a */
        public static final /* synthetic */ Direction[] f2359a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Direction] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Direction] */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Direction] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Direction] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Direction] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Direction] */
        static {
            ?? r6 = new Enum("LEFT", 0);
            LEFT = r6;
            ?? r7 = new Enum("RIGHT", 1);
            RIGHT = r7;
            ?? r8 = new Enum("START", 2);
            START = r8;
            ?? r9 = new Enum("END", 3);
            END = r9;
            ?? r10 = new Enum("TOP", 4);
            TOP = r10;
            ?? r11 = new Enum("BOTTOM", 5);
            BOTTOM = r11;
            f2359a = new Direction[]{r6, r7, r8, r9, r10, r11};
        }

        public static Direction valueOf(String str) {
            return (Direction) Enum.valueOf(Direction.class, str);
        }

        public static Direction[] values() {
            return (Direction[]) f2359a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Helper {
        public static final Helper ALIGN_HORIZONTALLY;
        public static final Helper ALIGN_VERTICALLY;
        public static final Helper BARRIER;
        public static final Helper COLUMN;
        public static final Helper FLOW;
        public static final Helper GRID;
        public static final Helper HORIZONTAL_CHAIN;
        public static final Helper HORIZONTAL_FLOW;
        public static final Helper LAYER;
        public static final Helper ROW;
        public static final Helper VERTICAL_CHAIN;
        public static final Helper VERTICAL_FLOW;

        /* renamed from: a */
        public static final /* synthetic */ Helper[] f2360a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Helper] */
        /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Helper] */
        /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Helper] */
        /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Helper] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Helper] */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Helper] */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Helper] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Helper] */
        /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Helper] */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Helper] */
        /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Helper] */
        /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Enum, androidx.constraintlayout.core.state.State$Helper] */
        static {
            ?? r12 = new Enum("HORIZONTAL_CHAIN", 0);
            HORIZONTAL_CHAIN = r12;
            ?? r13 = new Enum("VERTICAL_CHAIN", 1);
            VERTICAL_CHAIN = r13;
            ?? r14 = new Enum("ALIGN_HORIZONTALLY", 2);
            ALIGN_HORIZONTALLY = r14;
            ?? r15 = new Enum("ALIGN_VERTICALLY", 3);
            ALIGN_VERTICALLY = r15;
            ?? r9 = new Enum("BARRIER", 4);
            BARRIER = r9;
            ?? r8 = new Enum("LAYER", 5);
            LAYER = r8;
            ?? r7 = new Enum("HORIZONTAL_FLOW", 6);
            HORIZONTAL_FLOW = r7;
            ?? r6 = new Enum("VERTICAL_FLOW", 7);
            VERTICAL_FLOW = r6;
            ?? r5 = new Enum("GRID", 8);
            GRID = r5;
            ?? r4 = new Enum("ROW", 9);
            ROW = r4;
            ?? r3 = new Enum("COLUMN", 10);
            COLUMN = r3;
            ?? r2 = new Enum("FLOW", 11);
            FLOW = r2;
            f2360a = new Helper[]{r12, r13, r14, r15, r9, r8, r7, r6, r5, r4, r3, r2};
        }

        public static Helper valueOf(String str) {
            return (Helper) Enum.valueOf(Helper.class, str);
        }

        public static Helper[] values() {
            return (Helper[]) f2360a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Wrap {
        public static final Wrap ALIGNED;
        public static final Wrap CHAIN;
        public static final Wrap NONE;

        /* renamed from: a */
        public static final /* synthetic */ Wrap[] f2361a;
        public static Map<String, Integer> valueMap;
        public static Map<String, Wrap> wrapMap;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, java.lang.Object, androidx.constraintlayout.core.state.State$Wrap] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, java.lang.Object, androidx.constraintlayout.core.state.State$Wrap] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, java.lang.Object, androidx.constraintlayout.core.state.State$Wrap] */
        static {
            ?? r4 = new Enum("NONE", 0);
            NONE = r4;
            ?? r5 = new Enum("CHAIN", 1);
            CHAIN = r5;
            ?? r6 = new Enum("ALIGNED", 2);
            ALIGNED = r6;
            f2361a = new Wrap[]{r4, r5, r6};
            wrapMap = new HashMap();
            valueMap = new HashMap();
            wrapMap.put(SchedulerSupport.NONE, r4);
            wrapMap.put("chain", r5);
            wrapMap.put("aligned", r6);
            valueMap.put(SchedulerSupport.NONE, 0);
            valueMap.put("chain", 3);
            valueMap.put("aligned", 2);
        }

        public static Wrap getChainByString(String str) {
            if (wrapMap.containsKey(str)) {
                return wrapMap.get(str);
            }
            return null;
        }

        public static int getValueByString(String str) {
            if (valueMap.containsKey(str)) {
                return valueMap.get(str).intValue();
            }
            return -1;
        }

        public static Wrap valueOf(String str) {
            return (Wrap) Enum.valueOf(Wrap.class, str);
        }

        public static Wrap[] values() {
            return (Wrap[]) f2361a.clone();
        }
    }

    public State() {
        ConstraintReference constraintReference = new ConstraintReference(this);
        this.mParent = constraintReference;
        this.f2353d = 0;
        this.f2354e = new ArrayList();
        this.f2355f = new ArrayList();
        this.f2356g = true;
        Integer num = PARENT;
        constraintReference.setKey(num);
        this.mReferences.put(num, constraintReference);
    }

    public void apply(ConstraintWidgetContainer constraintWidgetContainer) {
        HelperReference helperReference;
        HelperWidget helperWidget;
        HelperWidget helperWidget2;
        constraintWidgetContainer.removeAllChildren();
        this.mParent.getWidth().apply(this, constraintWidgetContainer, 0);
        this.mParent.getHeight().apply(this, constraintWidgetContainer, 1);
        for (Object obj : this.mHelperReferences.keySet()) {
            HelperWidget helperWidget3 = this.mHelperReferences.get(obj).getHelperWidget();
            if (helperWidget3 != null) {
                Reference reference = this.mReferences.get(obj);
                if (reference == null) {
                    reference = constraints(obj);
                }
                reference.setConstraintWidget(helperWidget3);
            }
        }
        for (Object obj2 : this.mReferences.keySet()) {
            Reference reference2 = this.mReferences.get(obj2);
            if (reference2 != this.mParent && (reference2.getFacade() instanceof HelperReference) && (helperWidget2 = ((HelperReference) reference2.getFacade()).getHelperWidget()) != null) {
                Reference reference3 = this.mReferences.get(obj2);
                if (reference3 == null) {
                    reference3 = constraints(obj2);
                }
                reference3.setConstraintWidget(helperWidget2);
            }
        }
        Iterator<Object> it = this.mReferences.keySet().iterator();
        while (it.hasNext()) {
            Reference reference4 = this.mReferences.get(it.next());
            if (reference4 != this.mParent) {
                ConstraintWidget constraintWidget = reference4.getConstraintWidget();
                constraintWidget.setDebugName(reference4.getKey().toString());
                constraintWidget.setParent(null);
                if (reference4.getFacade() instanceof GuidelineReference) {
                    reference4.apply();
                }
                constraintWidgetContainer.add(constraintWidget);
            } else {
                reference4.setConstraintWidget(constraintWidgetContainer);
            }
        }
        Iterator<Object> it2 = this.mHelperReferences.keySet().iterator();
        while (it2.hasNext()) {
            HelperReference helperReference2 = this.mHelperReferences.get(it2.next());
            if (helperReference2.getHelperWidget() != null) {
                Iterator<Object> it3 = helperReference2.mReferences.iterator();
                while (it3.hasNext()) {
                    helperReference2.getHelperWidget().add(this.mReferences.get(it3.next()).getConstraintWidget());
                }
                helperReference2.apply();
            } else {
                helperReference2.apply();
            }
        }
        Iterator<Object> it4 = this.mReferences.keySet().iterator();
        while (it4.hasNext()) {
            Reference reference5 = this.mReferences.get(it4.next());
            if (reference5 != this.mParent && (reference5.getFacade() instanceof HelperReference) && (helperWidget = (helperReference = (HelperReference) reference5.getFacade()).getHelperWidget()) != null) {
                Iterator<Object> it5 = helperReference.mReferences.iterator();
                while (it5.hasNext()) {
                    Object next = it5.next();
                    Reference reference6 = this.mReferences.get(next);
                    if (reference6 != null) {
                        helperWidget.add(reference6.getConstraintWidget());
                    } else if (next instanceof Reference) {
                        helperWidget.add(((Reference) next).getConstraintWidget());
                    } else {
                        System.out.println("couldn't find reference for " + next);
                    }
                }
                reference5.apply();
            }
        }
        for (Object obj3 : this.mReferences.keySet()) {
            Reference reference7 = this.mReferences.get(obj3);
            reference7.apply();
            ConstraintWidget constraintWidget2 = reference7.getConstraintWidget();
            if (constraintWidget2 != null && obj3 != null) {
                constraintWidget2.stringId = obj3.toString();
            }
        }
    }

    public BarrierReference barrier(Object obj, Direction direction) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof BarrierReference)) {
            BarrierReference barrierReference = new BarrierReference(this);
            barrierReference.setBarrierDirection(direction);
            constraints.setFacade(barrierReference);
        }
        return (BarrierReference) constraints.getFacade();
    }

    public void baselineNeededFor(Object obj) {
        this.f2354e.add(obj);
        this.f2356g = true;
    }

    public AlignHorizontallyReference centerHorizontally(Object... objArr) {
        AlignHorizontallyReference alignHorizontallyReference = (AlignHorizontallyReference) helper(null, Helper.ALIGN_HORIZONTALLY);
        alignHorizontallyReference.add(objArr);
        return alignHorizontallyReference;
    }

    public AlignVerticallyReference centerVertically(Object... objArr) {
        AlignVerticallyReference alignVerticallyReference = (AlignVerticallyReference) helper(null, Helper.ALIGN_VERTICALLY);
        alignVerticallyReference.add(objArr);
        return alignVerticallyReference;
    }

    public ConstraintReference constraints(Object obj) {
        Reference reference = this.mReferences.get(obj);
        if (reference == null) {
            reference = createConstraintReference(obj);
            this.mReferences.put(obj, reference);
            reference.setKey(obj);
        }
        if (reference instanceof ConstraintReference) {
            return (ConstraintReference) reference;
        }
        return null;
    }

    public int convertDimension(Object obj) {
        if (obj instanceof Float) {
            return Math.round(((Float) obj).floatValue());
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public ConstraintReference createConstraintReference(Object obj) {
        return new ConstraintReference(this);
    }

    public void directMapping() {
        for (Object obj : this.mReferences.keySet()) {
            ConstraintReference constraints = constraints(obj);
            if (constraints instanceof ConstraintReference) {
                constraints.setView(obj);
            }
        }
    }

    public FlowReference getFlow(Object obj, boolean z) {
        FlowReference flowReference;
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof FlowReference)) {
            if (z) {
                flowReference = new FlowReference(this, Helper.VERTICAL_FLOW);
            } else {
                flowReference = new FlowReference(this, Helper.HORIZONTAL_FLOW);
            }
            constraints.setFacade(flowReference);
        }
        return (FlowReference) constraints.getFacade();
    }

    @NonNull
    public GridReference getGrid(@NonNull Object obj, @NonNull String str) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof GridReference)) {
            Helper helper = Helper.GRID;
            if (str.charAt(0) == 'r') {
                helper = Helper.ROW;
            } else if (str.charAt(0) == 'c') {
                helper = Helper.COLUMN;
            }
            constraints.setFacade(new GridReference(this, helper));
        }
        return (GridReference) constraints.getFacade();
    }

    public FlowReference getHorizontalFlow() {
        return (FlowReference) helper(null, Helper.HORIZONTAL_FLOW);
    }

    public ArrayList<String> getIdsForTag(String str) {
        HashMap hashMap = this.f2352c;
        if (hashMap.containsKey(str)) {
            return (ArrayList) hashMap.get(str);
        }
        return null;
    }

    public FlowReference getVerticalFlow() {
        return (FlowReference) helper(null, Helper.VERTICAL_FLOW);
    }

    public GuidelineReference guideline(Object obj, int i) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof GuidelineReference)) {
            GuidelineReference guidelineReference = new GuidelineReference(this);
            guidelineReference.setOrientation(i);
            guidelineReference.setKey(obj);
            constraints.setFacade(guidelineReference);
        }
        return (GuidelineReference) constraints.getFacade();
    }

    public State height(Dimension dimension) {
        return setHeight(dimension);
    }

    public HelperReference helper(Object obj, Helper helper) {
        HelperReference horizontalChainReference;
        if (obj == null) {
            StringBuilder sb = new StringBuilder("__HELPER_KEY_");
            int i = this.f2353d;
            this.f2353d = i + 1;
            obj = ye0.m8298r(sb, "__", i);
        }
        HelperReference helperReference = this.mHelperReferences.get(obj);
        if (helperReference == null) {
            switch (helper.ordinal()) {
                case 0:
                    horizontalChainReference = new HorizontalChainReference(this);
                    helperReference = horizontalChainReference;
                    break;
                case 1:
                    horizontalChainReference = new VerticalChainReference(this);
                    helperReference = horizontalChainReference;
                    break;
                case 2:
                    horizontalChainReference = new AlignHorizontallyReference(this);
                    helperReference = horizontalChainReference;
                    break;
                case 3:
                    horizontalChainReference = new AlignVerticallyReference(this);
                    helperReference = horizontalChainReference;
                    break;
                case 4:
                    horizontalChainReference = new BarrierReference(this);
                    helperReference = horizontalChainReference;
                    break;
                case 5:
                default:
                    helperReference = new HelperReference(this, helper);
                    break;
                case 6:
                case 7:
                    helperReference = new FlowReference(this, helper);
                    break;
                case 8:
                case 9:
                case 10:
                    helperReference = new GridReference(this, helper);
                    break;
            }
            helperReference.setKey(obj);
            this.mHelperReferences.put(obj, helperReference);
        }
        return helperReference;
    }

    public HorizontalChainReference horizontalChain() {
        return (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
    }

    public GuidelineReference horizontalGuideline(Object obj) {
        return guideline(obj, 0);
    }

    public boolean isBaselineNeeded(ConstraintWidget constraintWidget) {
        boolean z = this.f2356g;
        ArrayList arrayList = this.f2355f;
        if (z) {
            arrayList.clear();
            Iterator it = this.f2354e.iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget2 = this.mReferences.get(it.next()).getConstraintWidget();
                if (constraintWidget2 != null) {
                    arrayList.add(constraintWidget2);
                }
            }
            this.f2356g = false;
        }
        return arrayList.contains(constraintWidget);
    }

    @Deprecated
    public boolean isLtr() {
        return this.f2351b;
    }

    public boolean isRtl() {
        return !this.f2351b;
    }

    public void map(Object obj, Object obj2) {
        ConstraintReference constraints = constraints(obj);
        if (constraints != null) {
            constraints.setView(obj2);
        }
    }

    public void reset() {
        Iterator<Object> it = this.mReferences.keySet().iterator();
        while (it.hasNext()) {
            this.mReferences.get(it.next()).getConstraintWidget().reset();
        }
        this.mReferences.clear();
        this.mReferences.put(PARENT, this.mParent);
        this.mHelperReferences.clear();
        this.f2352c.clear();
        this.f2354e.clear();
        this.f2356g = true;
    }

    public boolean sameFixedHeight(int i) {
        return this.mParent.getHeight().equalsFixedValue(i);
    }

    public boolean sameFixedWidth(int i) {
        return this.mParent.getWidth().equalsFixedValue(i);
    }

    public void setDpToPixel(CorePixelDp corePixelDp) {
        this.f2350a = corePixelDp;
    }

    public State setHeight(Dimension dimension) {
        this.mParent.setHeight(dimension);
        return this;
    }

    @Deprecated
    public void setLtr(boolean z) {
        this.f2351b = z;
    }

    public void setRtl(boolean z) {
        this.f2351b = !z;
    }

    public void setTag(String str, String str2) {
        ArrayList arrayList;
        ConstraintReference constraints = constraints(str);
        if (constraints instanceof ConstraintReference) {
            constraints.setTag(str2);
            HashMap hashMap = this.f2352c;
            if (!hashMap.containsKey(str2)) {
                arrayList = new ArrayList();
                hashMap.put(str2, arrayList);
            } else {
                arrayList = (ArrayList) hashMap.get(str2);
            }
            arrayList.add(str);
        }
    }

    public State setWidth(Dimension dimension) {
        this.mParent.setWidth(dimension);
        return this;
    }

    public VerticalChainReference verticalChain() {
        return (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
    }

    public GuidelineReference verticalGuideline(Object obj) {
        return guideline(obj, 1);
    }

    public State width(Dimension dimension) {
        return setWidth(dimension);
    }

    public FlowReference getHorizontalFlow(Object... objArr) {
        FlowReference flowReference = (FlowReference) helper(null, Helper.HORIZONTAL_FLOW);
        flowReference.add(objArr);
        return flowReference;
    }

    public FlowReference getVerticalFlow(Object... objArr) {
        FlowReference flowReference = (FlowReference) helper(null, Helper.VERTICAL_FLOW);
        flowReference.add(objArr);
        return flowReference;
    }

    public HorizontalChainReference horizontalChain(Object... objArr) {
        HorizontalChainReference horizontalChainReference = (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
        horizontalChainReference.add(objArr);
        return horizontalChainReference;
    }

    public VerticalChainReference verticalChain(Object... objArr) {
        VerticalChainReference verticalChainReference = (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
        verticalChainReference.add(objArr);
        return verticalChainReference;
    }
}
