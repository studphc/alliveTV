package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.c40;

/* loaded from: classes.dex */
public class ChainRun extends WidgetRun {

    /* renamed from: e */
    public final ArrayList f2564e;

    /* renamed from: f */
    public int f2565f;

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        ConstraintWidget constraintWidget2;
        int verticalChainStyle;
        this.f2564e = new ArrayList();
        this.orientation = i;
        ConstraintWidget constraintWidget3 = this.f2591a;
        ConstraintWidget previousChainMember = constraintWidget3.getPreviousChainMember(i);
        while (true) {
            ConstraintWidget constraintWidget4 = previousChainMember;
            constraintWidget2 = constraintWidget3;
            constraintWidget3 = constraintWidget4;
            if (constraintWidget3 == null) {
                break;
            } else {
                previousChainMember = constraintWidget3.getPreviousChainMember(this.orientation);
            }
        }
        this.f2591a = constraintWidget2;
        WidgetRun run = constraintWidget2.getRun(this.orientation);
        ArrayList arrayList = this.f2564e;
        arrayList.add(run);
        ConstraintWidget nextChainMember = constraintWidget2.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            arrayList.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WidgetRun widgetRun = (WidgetRun) it.next();
            int i2 = this.orientation;
            if (i2 == 0) {
                widgetRun.f2591a.horizontalChainRun = this;
            } else if (i2 == 1) {
                widgetRun.f2591a.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.f2591a.getParent()).isRtl() && arrayList.size() > 1) {
            this.f2591a = ((WidgetRun) AbstractC1726qj.m7053i(arrayList, 1)).f2591a;
        }
        if (this.orientation == 0) {
            verticalChainStyle = this.f2591a.getHorizontalChainStyle();
        } else {
            verticalChainStyle = this.f2591a.getVerticalChainStyle();
        }
        this.f2565f = verticalChainStyle;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: a */
    public final void mo504a() {
        ArrayList arrayList = this.f2564e;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((WidgetRun) it.next()).mo504a();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = ((WidgetRun) arrayList.get(0)).f2591a;
        ConstraintWidget constraintWidget2 = ((WidgetRun) arrayList.get(size - 1)).f2591a;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget m507d = m507d();
            if (m507d != null) {
                margin = m507d.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget m508e = m508e();
            if (m508e != null) {
                margin2 = m508e.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget m507d2 = m507d();
            if (m507d2 != null) {
                margin3 = m507d2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget m508e2 = m508e();
            if (m508e2 != null) {
                margin4 = m508e2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f2564e;
            if (i < arrayList.size()) {
                ((WidgetRun) arrayList.get(i)).applyToWidget();
                i++;
            } else {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: b */
    public final void mo505b() {
        this.f2592b = null;
        Iterator it = this.f2564e.iterator();
        while (it.hasNext()) {
            ((WidgetRun) it.next()).mo505b();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: c */
    public final boolean mo506c() {
        ArrayList arrayList = this.f2564e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((WidgetRun) arrayList.get(i)).mo506c()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public final ConstraintWidget m507d() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f2564e;
            if (i < arrayList.size()) {
                WidgetRun widgetRun = (WidgetRun) arrayList.get(i);
                if (widgetRun.f2591a.getVisibility() != 8) {
                    return widgetRun.f2591a;
                }
                i++;
            } else {
                return null;
            }
        }
    }

    /* renamed from: e */
    public final ConstraintWidget m508e() {
        ArrayList arrayList = this.f2564e;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = (WidgetRun) arrayList.get(size);
            if (widgetRun.f2591a.getVisibility() != 8) {
                return widgetRun.f2591a;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        ArrayList arrayList = this.f2564e;
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            j = r5.end.f2576c + ((WidgetRun) arrayList.get(i)).getWrapDimension() + j + r5.start.f2576c;
        }
        return j;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ChainRun ");
        if (this.orientation == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        sb.append(str);
        Iterator it = this.f2564e.iterator();
        while (it.hasNext()) {
            WidgetRun widgetRun = (WidgetRun) it.next();
            sb.append("<");
            sb.append(widgetRun);
            sb.append("> ");
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:286:0x03e3, code lost:
    
        r10 = r10 - r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e6  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Dependency dependency) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        boolean z2;
        int i6;
        int i7;
        int i8;
        float verticalBiasPercent;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        float f2;
        int i17;
        int i18;
        boolean z3;
        int i19;
        boolean z4;
        int i20;
        int i21;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.f2591a.getParent();
            if (parent instanceof ConstraintWidgetContainer) {
                z = ((ConstraintWidgetContainer) parent).isRtl();
            } else {
                z = false;
            }
            int i22 = this.end.value - this.start.value;
            ArrayList arrayList = this.f2564e;
            int size = arrayList.size();
            int i23 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i23 < size) {
                    if (((WidgetRun) arrayList.get(i23)).f2591a.getVisibility() != 8) {
                        break;
                    } else {
                        i23++;
                    }
                } else {
                    i23 = -1;
                    break;
                }
            }
            int i24 = size - 1;
            int i25 = i24;
            while (true) {
                if (i25 < 0) {
                    break;
                }
                if (((WidgetRun) arrayList.get(i25)).f2591a.getVisibility() != 8) {
                    i = i25;
                    break;
                }
                i25--;
            }
            int i26 = 0;
            while (i26 < 2) {
                int i27 = 0;
                i5 = 0;
                int i28 = 0;
                int i29 = 0;
                f = RecyclerView.f7068F0;
                while (i27 < size) {
                    WidgetRun widgetRun = (WidgetRun) arrayList.get(i27);
                    if (widgetRun.f2591a.getVisibility() != i2) {
                        i29++;
                        if (i27 > 0 && i27 >= i23) {
                            i5 += widgetRun.start.f2576c;
                        }
                        c40 c40Var = widgetRun.f2593c;
                        int i30 = c40Var.value;
                        if (widgetRun.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            int i31 = this.orientation;
                            if (i31 == 0 && !widgetRun.f2591a.mHorizontalRun.f2593c.resolved) {
                                return;
                            }
                            if (i31 == 1 && !widgetRun.f2591a.mVerticalRun.f2593c.resolved) {
                                return;
                            } else {
                                i20 = i30;
                            }
                        } else {
                            i20 = i30;
                            if (widgetRun.matchConstraintsType == 1 && i26 == 0) {
                                i21 = c40Var.f8247h;
                                i28++;
                            } else if (c40Var.resolved) {
                                i21 = i20;
                            }
                            z4 = true;
                            if (z4) {
                                i28++;
                                float f3 = widgetRun.f2591a.mWeight[this.orientation];
                                if (f3 >= RecyclerView.f7068F0) {
                                    f += f3;
                                }
                            } else {
                                i5 += i21;
                            }
                            if (i27 < i24 && i27 < i) {
                                i5 += -widgetRun.end.f2576c;
                            }
                        }
                        i21 = i20;
                        if (z4) {
                        }
                        if (i27 < i24) {
                            i5 += -widgetRun.end.f2576c;
                        }
                    }
                    i27++;
                    i2 = 8;
                }
                if (i5 >= i22 && i28 != 0) {
                    i26++;
                    i2 = 8;
                } else {
                    i3 = i28;
                    i4 = i29;
                    break;
                }
            }
            i3 = 0;
            i4 = 0;
            i5 = 0;
            f = RecyclerView.f7068F0;
            int i32 = this.start.value;
            if (z) {
                i32 = this.end.value;
            }
            if (i5 > i22) {
                if (z) {
                    i32 += (int) (((i5 - i22) / 2.0f) + 0.5f);
                } else {
                    i32 -= (int) (((i5 - i22) / 2.0f) + 0.5f);
                }
            }
            if (i3 > 0) {
                float f4 = i22 - i5;
                int i33 = (int) ((f4 / i3) + 0.5f);
                int i34 = 0;
                int i35 = 0;
                while (i34 < size) {
                    WidgetRun widgetRun2 = (WidgetRun) arrayList.get(i34);
                    int i36 = i33;
                    int i37 = i5;
                    if (widgetRun2.f2591a.getVisibility() != 8 && widgetRun2.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        c40 c40Var2 = widgetRun2.f2593c;
                        if (!c40Var2.resolved) {
                            if (f > RecyclerView.f7068F0) {
                                i15 = i32;
                                i16 = (int) (((widgetRun2.f2591a.mWeight[this.orientation] * f4) / f) + 0.5f);
                            } else {
                                i15 = i32;
                                i16 = i36;
                            }
                            if (this.orientation == 0) {
                                ConstraintWidget constraintWidget = widgetRun2.f2591a;
                                f2 = f4;
                                i18 = constraintWidget.mMatchConstraintMaxWidth;
                                i17 = constraintWidget.mMatchConstraintMinWidth;
                            } else {
                                f2 = f4;
                                ConstraintWidget constraintWidget2 = widgetRun2.f2591a;
                                int i38 = constraintWidget2.mMatchConstraintMaxHeight;
                                i17 = constraintWidget2.mMatchConstraintMinHeight;
                                i18 = i38;
                            }
                            z3 = z;
                            if (widgetRun2.matchConstraintsType == 1) {
                                i19 = Math.min(i16, c40Var2.f8247h);
                            } else {
                                i19 = i16;
                            }
                            int max = Math.max(i17, i19);
                            if (i18 > 0) {
                                max = Math.min(i18, max);
                            }
                            if (max != i16) {
                                i35++;
                                i16 = max;
                            }
                            c40Var2.resolve(i16);
                            i34++;
                            i33 = i36;
                            i5 = i37;
                            i32 = i15;
                            f4 = f2;
                            z = z3;
                        }
                    }
                    z3 = z;
                    i15 = i32;
                    f2 = f4;
                    i34++;
                    i33 = i36;
                    i5 = i37;
                    i32 = i15;
                    f4 = f2;
                    z = z3;
                }
                z2 = z;
                i6 = i32;
                int i39 = i5;
                if (i35 > 0) {
                    i3 -= i35;
                    i5 = 0;
                    for (int i40 = 0; i40 < size; i40++) {
                        WidgetRun widgetRun3 = (WidgetRun) arrayList.get(i40);
                        if (widgetRun3.f2591a.getVisibility() != 8) {
                            if (i40 > 0 && i40 >= i23) {
                                i5 += widgetRun3.start.f2576c;
                            }
                            i5 += widgetRun3.f2593c.value;
                            if (i40 < i24 && i40 < i) {
                                i5 += -widgetRun3.end.f2576c;
                            }
                        }
                    }
                } else {
                    i5 = i39;
                }
                i8 = 2;
                if (this.f2565f == 2 && i35 == 0) {
                    i7 = 0;
                    this.f2565f = 0;
                } else {
                    i7 = 0;
                }
            } else {
                z2 = z;
                i6 = i32;
                i7 = 0;
                i8 = 2;
            }
            if (i5 > i22) {
                this.f2565f = i8;
            }
            if (i4 > 0 && i3 == 0 && i23 == i) {
                this.f2565f = i8;
            }
            int i41 = this.f2565f;
            if (i41 == 1) {
                if (i4 > 1) {
                    i13 = (i22 - i5) / (i4 - 1);
                } else if (i4 == 1) {
                    i13 = (i22 - i5) / 2;
                } else {
                    i13 = i7;
                }
                if (i3 > 0) {
                    i13 = i7;
                }
                int i42 = i6;
                for (int i43 = i7; i43 < size; i43++) {
                    if (z2) {
                        i14 = size - (i43 + 1);
                    } else {
                        i14 = i43;
                    }
                    WidgetRun widgetRun4 = (WidgetRun) arrayList.get(i14);
                    if (widgetRun4.f2591a.getVisibility() == 8) {
                        widgetRun4.start.resolve(i42);
                        widgetRun4.end.resolve(i42);
                    } else {
                        if (i43 > 0) {
                            if (z2) {
                                i42 -= i13;
                            } else {
                                i42 += i13;
                            }
                        }
                        if (i43 > 0 && i43 >= i23) {
                            if (z2) {
                                i42 -= widgetRun4.start.f2576c;
                            } else {
                                i42 += widgetRun4.start.f2576c;
                            }
                        }
                        if (z2) {
                            widgetRun4.end.resolve(i42);
                        } else {
                            widgetRun4.start.resolve(i42);
                        }
                        c40 c40Var3 = widgetRun4.f2593c;
                        int i44 = c40Var3.value;
                        if (widgetRun4.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i44 = c40Var3.f8247h;
                        }
                        if (z2) {
                            i42 -= i44;
                        } else {
                            i42 += i44;
                        }
                        if (z2) {
                            widgetRun4.start.resolve(i42);
                        } else {
                            widgetRun4.end.resolve(i42);
                        }
                        widgetRun4.f2594d = true;
                        if (i43 < i24 && i43 < i) {
                            if (z2) {
                                i42 -= -widgetRun4.end.f2576c;
                            } else {
                                i42 += -widgetRun4.end.f2576c;
                            }
                        }
                    }
                }
                return;
            }
            if (i41 == 0) {
                int i45 = (i22 - i5) / (i4 + 1);
                if (i3 > 0) {
                    i45 = i7;
                }
                int i46 = i6;
                for (int i47 = i7; i47 < size; i47++) {
                    if (z2) {
                        i11 = size - (i47 + 1);
                    } else {
                        i11 = i47;
                    }
                    WidgetRun widgetRun5 = (WidgetRun) arrayList.get(i11);
                    if (widgetRun5.f2591a.getVisibility() == 8) {
                        widgetRun5.start.resolve(i46);
                        widgetRun5.end.resolve(i46);
                    } else {
                        if (z2) {
                            i12 = i46 - i45;
                        } else {
                            i12 = i46 + i45;
                        }
                        if (i47 > 0 && i47 >= i23) {
                            if (z2) {
                                i12 -= widgetRun5.start.f2576c;
                            } else {
                                i12 += widgetRun5.start.f2576c;
                            }
                        }
                        if (z2) {
                            widgetRun5.end.resolve(i12);
                        } else {
                            widgetRun5.start.resolve(i12);
                        }
                        c40 c40Var4 = widgetRun5.f2593c;
                        int i48 = c40Var4.value;
                        if (widgetRun5.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            i48 = Math.min(i48, c40Var4.f8247h);
                        }
                        if (z2) {
                            i46 = i12 - i48;
                        } else {
                            i46 = i12 + i48;
                        }
                        if (z2) {
                            widgetRun5.start.resolve(i46);
                        } else {
                            widgetRun5.end.resolve(i46);
                        }
                        if (i47 < i24 && i47 < i) {
                            if (z2) {
                                i46 -= -widgetRun5.end.f2576c;
                            } else {
                                i46 += -widgetRun5.end.f2576c;
                            }
                        }
                    }
                }
                return;
            }
            if (i41 == 2) {
                if (this.orientation == 0) {
                    verticalBiasPercent = this.f2591a.getHorizontalBiasPercent();
                } else {
                    verticalBiasPercent = this.f2591a.getVerticalBiasPercent();
                }
                if (z2) {
                    verticalBiasPercent = 1.0f - verticalBiasPercent;
                }
                int i49 = (int) (((i22 - i5) * verticalBiasPercent) + 0.5f);
                if (i49 < 0 || i3 > 0) {
                    i49 = i7;
                }
                if (z2) {
                    i9 = i6 - i49;
                } else {
                    i9 = i6 + i49;
                }
                for (int i50 = i7; i50 < size; i50++) {
                    if (z2) {
                        i10 = size - (i50 + 1);
                    } else {
                        i10 = i50;
                    }
                    WidgetRun widgetRun6 = (WidgetRun) arrayList.get(i10);
                    if (widgetRun6.f2591a.getVisibility() == 8) {
                        widgetRun6.start.resolve(i9);
                        widgetRun6.end.resolve(i9);
                    } else {
                        if (i50 > 0 && i50 >= i23) {
                            if (z2) {
                                i9 -= widgetRun6.start.f2576c;
                            } else {
                                i9 += widgetRun6.start.f2576c;
                            }
                        }
                        if (z2) {
                            widgetRun6.end.resolve(i9);
                        } else {
                            widgetRun6.start.resolve(i9);
                        }
                        c40 c40Var5 = widgetRun6.f2593c;
                        int i51 = c40Var5.value;
                        if (widgetRun6.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i51 = c40Var5.f8247h;
                        }
                        i9 += i51;
                        if (z2) {
                            widgetRun6.start.resolve(i9);
                        } else {
                            widgetRun6.end.resolve(i9);
                        }
                        if (i50 < i24 && i50 < i) {
                            if (z2) {
                                i9 -= -widgetRun6.end.f2576c;
                            } else {
                                i9 += -widgetRun6.end.f2576c;
                            }
                        }
                    }
                }
            }
        }
    }
}
