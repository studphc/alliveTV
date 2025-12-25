package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Chain {
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0547 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0582 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05a1 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0316 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0413 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0535 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r1v60, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v36 */
    /* JADX WARN: Type inference failed for: r9v37 */
    /* JADX WARN: Type inference failed for: r9v5, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        boolean z;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        ConstraintWidget constraintWidget;
        boolean z5;
        SolverVariable solverVariable;
        int i5;
        ArrayList<ConstraintWidget> arrayList2;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        int i6;
        ConstraintWidget constraintWidget5;
        int i7;
        boolean z6;
        ConstraintWidget constraintWidget6;
        ConstraintAnchor constraintAnchor;
        int i8;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintWidget constraintWidget7;
        ConstraintWidget constraintWidget8;
        ConstraintWidget constraintWidget9;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        ConstraintAnchor constraintAnchor5;
        SolverVariable solverVariable4;
        int i9;
        int i10;
        ConstraintWidget constraintWidget10;
        boolean z7;
        SolverVariable solverVariable5;
        ConstraintWidget constraintWidget11;
        ConstraintAnchor constraintAnchor6;
        ConstraintWidget constraintWidget12;
        SolverVariable solverVariable6;
        ConstraintWidget constraintWidget13;
        ConstraintWidget constraintWidget14;
        ConstraintWidget constraintWidget15;
        ConstraintWidget constraintWidget16;
        int i11;
        int i12;
        ConstraintWidget constraintWidget17;
        ConstraintAnchor constraintAnchor7;
        SolverVariable solverVariable7;
        ConstraintAnchor constraintAnchor8;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        ConstraintWidget constraintWidget18;
        float f;
        int size;
        int i13;
        ArrayList<ConstraintWidget> arrayList3;
        int i14;
        int i15;
        boolean z8;
        ConstraintWidget constraintWidget19;
        ChainHead chainHead;
        ConstraintWidget constraintWidget20;
        int i16;
        int i17;
        boolean z9;
        int i18;
        boolean z10;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        ArrayList<ConstraintWidget> arrayList4 = arrayList;
        int i19 = i;
        if (i19 == 0) {
            i2 = constraintWidgetContainer2.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer2.f2509P;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer2.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer2.f2508O;
            i3 = 2;
        }
        int i20 = 0;
        while (i20 < i2) {
            ChainHead chainHead2 = chainHeadArr[i20];
            chainHead2.define();
            if (arrayList4 != null && !arrayList4.contains(chainHead2.mFirst)) {
                i6 = i20;
                i5 = i2;
            } else {
                ConstraintWidget constraintWidget21 = chainHead2.mFirst;
                ConstraintWidget constraintWidget22 = chainHead2.mLast;
                ConstraintWidget constraintWidget23 = chainHead2.mFirstVisibleWidget;
                ConstraintWidget constraintWidget24 = chainHead2.mLastVisibleWidget;
                ConstraintWidget constraintWidget25 = chainHead2.mHead;
                float f2 = chainHead2.mTotalWeight;
                if (constraintWidgetContainer2.mListDimensionBehaviors[i19] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z = true;
                } else {
                    z = false;
                }
                if (i19 == 0) {
                    int i21 = constraintWidget25.f2470F;
                    if (i21 == 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    i4 = i20;
                    if (i21 == 1) {
                        z10 = true;
                        i18 = 2;
                    } else {
                        i18 = 2;
                        z10 = false;
                    }
                    if (i21 == i18) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    constraintWidget = constraintWidget21;
                    z5 = z9;
                    z3 = z10;
                } else {
                    i4 = i20;
                    int i22 = constraintWidget25.f2471G;
                    if (i22 == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (i22 == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (i22 == 2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    constraintWidget = constraintWidget21;
                    z5 = z2;
                }
                boolean z11 = false;
                ?? r9 = constraintWidget;
                while (true) {
                    solverVariable = null;
                    if (z11) {
                        break;
                    }
                    ConstraintAnchor constraintAnchor9 = r9.mListAnchors[i3];
                    if (z4) {
                        i14 = 1;
                    } else {
                        i14 = 4;
                    }
                    int margin = constraintAnchor9.getMargin();
                    float f3 = f2;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = r9.mListDimensionBehaviors[i19];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour == dimensionBehaviour2 && r9.mResolvedMatchConstraintDefault[i19] == 0) {
                        i15 = i2;
                        z8 = true;
                    } else {
                        i15 = i2;
                        z8 = false;
                    }
                    ConstraintAnchor constraintAnchor10 = constraintAnchor9.mTarget;
                    if (constraintAnchor10 != null && r9 != constraintWidget21) {
                        margin = constraintAnchor10.getMargin() + margin;
                    }
                    int i23 = margin;
                    if (z4 && r9 != constraintWidget21 && r9 != constraintWidget23) {
                        constraintWidget19 = constraintWidget25;
                        i14 = 8;
                    } else {
                        constraintWidget19 = constraintWidget25;
                    }
                    ConstraintAnchor constraintAnchor11 = constraintAnchor9.mTarget;
                    if (constraintAnchor11 != null) {
                        if (r9 == constraintWidget23) {
                            constraintWidget20 = constraintWidget21;
                            chainHead = chainHead2;
                            linearSystem.addGreaterThan(constraintAnchor9.f2463e, constraintAnchor11.f2463e, i23, 6);
                        } else {
                            chainHead = chainHead2;
                            constraintWidget20 = constraintWidget21;
                            linearSystem.addGreaterThan(constraintAnchor9.f2463e, constraintAnchor11.f2463e, i23, 8);
                        }
                        if (z8 && !z4) {
                            i14 = 5;
                        }
                        if (r9 == constraintWidget23 && z4 && r9.isInBarrier(i19)) {
                            i17 = 5;
                        } else {
                            i17 = i14;
                        }
                        linearSystem.addEquality(constraintAnchor9.f2463e, constraintAnchor9.mTarget.f2463e, i23, i17);
                    } else {
                        chainHead = chainHead2;
                        constraintWidget20 = constraintWidget21;
                    }
                    if (z) {
                        if (r9.getVisibility() != 8 && r9.mListDimensionBehaviors[i19] == dimensionBehaviour2) {
                            ConstraintAnchor[] constraintAnchorArr = r9.mListAnchors;
                            i16 = 0;
                            linearSystem.addGreaterThan(constraintAnchorArr[i3 + 1].f2463e, constraintAnchorArr[i3].f2463e, 0, 5);
                        } else {
                            i16 = 0;
                        }
                        linearSystem.addGreaterThan(r9.mListAnchors[i3].f2463e, constraintWidgetContainer2.mListAnchors[i3].f2463e, i16, 8);
                    }
                    ConstraintAnchor constraintAnchor12 = r9.mListAnchors[i3 + 1].mTarget;
                    if (constraintAnchor12 != null) {
                        ?? r1 = constraintAnchor12.mOwner;
                        ConstraintAnchor constraintAnchor13 = r1.mListAnchors[i3].mTarget;
                        if (constraintAnchor13 != null && constraintAnchor13.mOwner == r9) {
                            solverVariable = r1;
                        }
                    }
                    if (solverVariable != null) {
                        r9 = solverVariable;
                    } else {
                        z11 = true;
                    }
                    constraintWidget25 = constraintWidget19;
                    f2 = f3;
                    i2 = i15;
                    constraintWidget21 = constraintWidget20;
                    chainHead2 = chainHead;
                    r9 = r9;
                }
                ChainHead chainHead3 = chainHead2;
                ConstraintWidget constraintWidget26 = constraintWidget25;
                float f4 = f2;
                ConstraintWidget constraintWidget27 = constraintWidget21;
                i5 = i2;
                if (constraintWidget24 != null) {
                    int i24 = i3 + 1;
                    if (constraintWidget22.mListAnchors[i24].mTarget != null) {
                        ConstraintAnchor constraintAnchor14 = constraintWidget24.mListAnchors[i24];
                        if (constraintWidget24.mListDimensionBehaviors[i19] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget24.mResolvedMatchConstraintDefault[i19] == 0 && !z4) {
                            ConstraintAnchor constraintAnchor15 = constraintAnchor14.mTarget;
                            if (constraintAnchor15.mOwner == constraintWidgetContainer2) {
                                linearSystem.addEquality(constraintAnchor14.f2463e, constraintAnchor15.f2463e, -constraintAnchor14.getMargin(), 5);
                                linearSystem.addLowerThan(constraintAnchor14.f2463e, constraintWidget22.mListAnchors[i24].mTarget.f2463e, -constraintAnchor14.getMargin(), 6);
                                if (z) {
                                    int i25 = i3 + 1;
                                    SolverVariable solverVariable11 = constraintWidgetContainer2.mListAnchors[i25].f2463e;
                                    ConstraintAnchor constraintAnchor16 = constraintWidget22.mListAnchors[i25];
                                    linearSystem.addGreaterThan(solverVariable11, constraintAnchor16.f2463e, constraintAnchor16.getMargin(), 8);
                                }
                                arrayList2 = chainHead3.mWeightedMatchConstraintsWidgets;
                                if (arrayList2 != null && (size = arrayList2.size()) > 1) {
                                    if (chainHead3.mHasUndefinedWeights && !chainHead3.mHasComplexMatchWeights) {
                                        f4 = chainHead3.mWidgetsMatchCount;
                                    }
                                    float f5 = RecyclerView.f7068F0;
                                    float f6 = 0.0f;
                                    ConstraintWidget constraintWidget28 = null;
                                    i13 = 0;
                                    while (i13 < size) {
                                        ConstraintWidget constraintWidget29 = arrayList2.get(i13);
                                        float f7 = constraintWidget29.mWeight[i19];
                                        if (f7 < f5) {
                                            if (chainHead3.mHasComplexMatchWeights) {
                                                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget29.mListAnchors;
                                                linearSystem.addEquality(constraintAnchorArr2[i3 + 1].f2463e, constraintAnchorArr2[i3].f2463e, 0, 4);
                                                arrayList3 = arrayList2;
                                                i13++;
                                                arrayList2 = arrayList3;
                                                f5 = RecyclerView.f7068F0;
                                            } else {
                                                f7 = 1.0f;
                                            }
                                        }
                                        if (f7 == RecyclerView.f7068F0) {
                                            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget29.mListAnchors;
                                            linearSystem.addEquality(constraintAnchorArr3[i3 + 1].f2463e, constraintAnchorArr3[i3].f2463e, 0, 8);
                                            arrayList3 = arrayList2;
                                            i13++;
                                            arrayList2 = arrayList3;
                                            f5 = RecyclerView.f7068F0;
                                        } else {
                                            if (constraintWidget28 != null) {
                                                ConstraintAnchor[] constraintAnchorArr4 = constraintWidget28.mListAnchors;
                                                SolverVariable solverVariable12 = constraintAnchorArr4[i3].f2463e;
                                                int i26 = i3 + 1;
                                                SolverVariable solverVariable13 = constraintAnchorArr4[i26].f2463e;
                                                ConstraintAnchor[] constraintAnchorArr5 = constraintWidget29.mListAnchors;
                                                SolverVariable solverVariable14 = constraintAnchorArr5[i3].f2463e;
                                                SolverVariable solverVariable15 = constraintAnchorArr5[i26].f2463e;
                                                arrayList3 = arrayList2;
                                                ArrayRow createRow = linearSystem.createRow();
                                                createRow.createRowEqualMatchDimensions(f6, f4, f7, solverVariable12, solverVariable13, solverVariable14, solverVariable15);
                                                linearSystem.addConstraint(createRow);
                                            } else {
                                                arrayList3 = arrayList2;
                                            }
                                            f6 = f7;
                                            constraintWidget28 = constraintWidget29;
                                            i13++;
                                            arrayList2 = arrayList3;
                                            f5 = RecyclerView.f7068F0;
                                        }
                                    }
                                }
                                if (constraintWidget23 != null || (constraintWidget23 != constraintWidget24 && !z4)) {
                                    constraintWidget2 = constraintWidget24;
                                    constraintWidget3 = constraintWidget23;
                                    constraintWidget4 = constraintWidget22;
                                    i6 = i4;
                                    constraintWidget5 = constraintWidget27;
                                    if (!z5 && constraintWidget3 != null) {
                                        int i27 = chainHead3.mWidgetsMatchCount;
                                        if (i27 > 0 && chainHead3.mWidgetsCount == i27) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        ConstraintWidget constraintWidget30 = constraintWidget3;
                                        ConstraintWidget constraintWidget31 = constraintWidget30;
                                        while (constraintWidget31 != null) {
                                            ConstraintWidget constraintWidget32 = constraintWidget31.mNextChainWidget[i19];
                                            while (constraintWidget32 != null && constraintWidget32.getVisibility() == 8) {
                                                constraintWidget32 = constraintWidget32.mNextChainWidget[i19];
                                            }
                                            if (constraintWidget32 == null && constraintWidget31 != constraintWidget2) {
                                                constraintWidget15 = constraintWidget5;
                                                constraintWidget14 = constraintWidget32;
                                                constraintWidget16 = constraintWidget30;
                                                constraintWidget13 = constraintWidget31;
                                            } else {
                                                ConstraintAnchor constraintAnchor17 = constraintWidget31.mListAnchors[i3];
                                                SolverVariable solverVariable16 = constraintAnchor17.f2463e;
                                                ConstraintAnchor constraintAnchor18 = constraintAnchor17.mTarget;
                                                if (constraintAnchor18 != null) {
                                                    solverVariable5 = constraintAnchor18.f2463e;
                                                } else {
                                                    solverVariable5 = null;
                                                }
                                                if (constraintWidget30 != constraintWidget31) {
                                                    solverVariable5 = constraintWidget30.mListAnchors[i3 + 1].f2463e;
                                                } else if (constraintWidget31 == constraintWidget3) {
                                                    ConstraintAnchor constraintAnchor19 = constraintWidget5.mListAnchors[i3].mTarget;
                                                    if (constraintAnchor19 != null) {
                                                        solverVariable5 = constraintAnchor19.f2463e;
                                                    } else {
                                                        solverVariable5 = null;
                                                    }
                                                }
                                                int margin2 = constraintAnchor17.getMargin();
                                                int i28 = i3 + 1;
                                                int margin3 = constraintWidget31.mListAnchors[i28].getMargin();
                                                if (constraintWidget32 != null) {
                                                    constraintAnchor6 = constraintWidget32.mListAnchors[i3];
                                                    constraintWidget11 = constraintWidget5;
                                                    solverVariable6 = constraintAnchor6.f2463e;
                                                } else {
                                                    constraintWidget11 = constraintWidget5;
                                                    constraintAnchor6 = constraintWidget4.mListAnchors[i28].mTarget;
                                                    if (constraintAnchor6 != null) {
                                                        solverVariable6 = constraintAnchor6.f2463e;
                                                    } else {
                                                        constraintWidget12 = constraintWidget32;
                                                        solverVariable6 = null;
                                                        SolverVariable solverVariable17 = constraintWidget31.mListAnchors[i28].f2463e;
                                                        if (constraintAnchor6 != null) {
                                                            margin3 += constraintAnchor6.getMargin();
                                                        }
                                                        int margin4 = constraintWidget30.mListAnchors[i28].getMargin() + margin2;
                                                        if (solverVariable16 == null && solverVariable5 != null && solverVariable6 != null && solverVariable17 != null) {
                                                            if (constraintWidget31 == constraintWidget3) {
                                                                margin4 = constraintWidget3.mListAnchors[i3].getMargin();
                                                            }
                                                            if (constraintWidget31 == constraintWidget2) {
                                                                i11 = constraintWidget2.mListAnchors[i28].getMargin();
                                                            } else {
                                                                i11 = margin3;
                                                            }
                                                            if (z7) {
                                                                i12 = 8;
                                                            } else {
                                                                i12 = 5;
                                                            }
                                                            int i29 = margin4;
                                                            SolverVariable solverVariable18 = solverVariable6;
                                                            constraintWidget14 = constraintWidget12;
                                                            constraintWidget16 = constraintWidget30;
                                                            constraintWidget15 = constraintWidget11;
                                                            int i30 = i11;
                                                            constraintWidget13 = constraintWidget31;
                                                            linearSystem.addCentering(solverVariable16, solverVariable5, i29, 0.5f, solverVariable18, solverVariable17, i30, i12);
                                                        } else {
                                                            constraintWidget13 = constraintWidget31;
                                                            constraintWidget14 = constraintWidget12;
                                                            constraintWidget15 = constraintWidget11;
                                                            constraintWidget16 = constraintWidget30;
                                                        }
                                                    }
                                                }
                                                constraintWidget12 = constraintWidget32;
                                                SolverVariable solverVariable172 = constraintWidget31.mListAnchors[i28].f2463e;
                                                if (constraintAnchor6 != null) {
                                                }
                                                int margin42 = constraintWidget30.mListAnchors[i28].getMargin() + margin2;
                                                if (solverVariable16 == null) {
                                                }
                                                constraintWidget13 = constraintWidget31;
                                                constraintWidget14 = constraintWidget12;
                                                constraintWidget15 = constraintWidget11;
                                                constraintWidget16 = constraintWidget30;
                                            }
                                            if (constraintWidget13.getVisibility() != 8) {
                                                constraintWidget30 = constraintWidget13;
                                            } else {
                                                constraintWidget30 = constraintWidget16;
                                            }
                                            constraintWidget31 = constraintWidget14;
                                            constraintWidget5 = constraintWidget15;
                                        }
                                    } else if (z3 && constraintWidget3 != null) {
                                        i7 = chainHead3.mWidgetsMatchCount;
                                        if (i7 <= 0 && chainHead3.mWidgetsCount == i7) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        constraintWidget6 = constraintWidget3;
                                        ConstraintWidget constraintWidget33 = constraintWidget6;
                                        while (constraintWidget6 != null) {
                                            ConstraintWidget constraintWidget34 = constraintWidget6.mNextChainWidget[i19];
                                            while (constraintWidget34 != null && constraintWidget34.getVisibility() == 8) {
                                                constraintWidget34 = constraintWidget34.mNextChainWidget[i19];
                                            }
                                            if (constraintWidget6 != constraintWidget3 && constraintWidget6 != constraintWidget2 && constraintWidget34 != null) {
                                                if (constraintWidget34 == constraintWidget2) {
                                                    constraintWidget9 = null;
                                                } else {
                                                    constraintWidget9 = constraintWidget34;
                                                }
                                                ConstraintAnchor constraintAnchor20 = constraintWidget6.mListAnchors[i3];
                                                SolverVariable solverVariable19 = constraintAnchor20.f2463e;
                                                int i31 = i3 + 1;
                                                SolverVariable solverVariable20 = constraintWidget33.mListAnchors[i31].f2463e;
                                                int margin5 = constraintAnchor20.getMargin();
                                                int margin6 = constraintWidget6.mListAnchors[i31].getMargin();
                                                if (constraintWidget9 != null) {
                                                    constraintAnchor5 = constraintWidget9.mListAnchors[i3];
                                                    solverVariable4 = constraintAnchor5.f2463e;
                                                    ConstraintAnchor constraintAnchor21 = constraintAnchor5.mTarget;
                                                    if (constraintAnchor21 != null) {
                                                        solverVariable3 = constraintAnchor21.f2463e;
                                                    } else {
                                                        solverVariable3 = null;
                                                    }
                                                } else {
                                                    ConstraintAnchor constraintAnchor22 = constraintWidget2.mListAnchors[i3];
                                                    if (constraintAnchor22 != null) {
                                                        solverVariable2 = constraintAnchor22.f2463e;
                                                        constraintAnchor4 = constraintAnchor22;
                                                    } else {
                                                        constraintAnchor4 = constraintAnchor22;
                                                        solverVariable2 = null;
                                                    }
                                                    SolverVariable solverVariable21 = solverVariable2;
                                                    solverVariable3 = constraintWidget6.mListAnchors[i31].f2463e;
                                                    constraintAnchor5 = constraintAnchor4;
                                                    solverVariable4 = solverVariable21;
                                                }
                                                if (constraintAnchor5 != null) {
                                                    i9 = constraintAnchor5.getMargin() + margin6;
                                                } else {
                                                    i9 = margin6;
                                                }
                                                int margin7 = constraintWidget33.mListAnchors[i31].getMargin() + margin5;
                                                if (z6) {
                                                    i10 = 8;
                                                } else {
                                                    i10 = 4;
                                                }
                                                if (solverVariable19 != null && solverVariable20 != null && solverVariable4 != null && solverVariable3 != null) {
                                                    constraintWidget10 = constraintWidget9;
                                                    int i32 = i9;
                                                    constraintWidget7 = constraintWidget33;
                                                    linearSystem.addCentering(solverVariable19, solverVariable20, margin7, 0.5f, solverVariable4, solverVariable3, i32, i10);
                                                } else {
                                                    constraintWidget10 = constraintWidget9;
                                                    constraintWidget7 = constraintWidget33;
                                                }
                                                constraintWidget8 = constraintWidget10;
                                            } else {
                                                constraintWidget7 = constraintWidget33;
                                                constraintWidget8 = constraintWidget34;
                                            }
                                            if (constraintWidget6.getVisibility() != 8) {
                                                constraintWidget33 = constraintWidget6;
                                            } else {
                                                constraintWidget33 = constraintWidget7;
                                            }
                                            constraintWidget6 = constraintWidget8;
                                        }
                                        ConstraintAnchor constraintAnchor23 = constraintWidget3.mListAnchors[i3];
                                        constraintAnchor = constraintWidget5.mListAnchors[i3].mTarget;
                                        int i33 = i3 + 1;
                                        ConstraintAnchor constraintAnchor24 = constraintWidget2.mListAnchors[i33];
                                        ConstraintAnchor constraintAnchor25 = constraintWidget4.mListAnchors[i33].mTarget;
                                        if (constraintAnchor != null) {
                                            if (constraintWidget3 != constraintWidget2) {
                                                linearSystem.addEquality(constraintAnchor23.f2463e, constraintAnchor.f2463e, constraintAnchor23.getMargin(), 5);
                                            } else if (constraintAnchor25 != null) {
                                                i8 = 5;
                                                constraintAnchor2 = constraintAnchor25;
                                                constraintAnchor3 = constraintAnchor24;
                                                linearSystem.addCentering(constraintAnchor23.f2463e, constraintAnchor.f2463e, constraintAnchor23.getMargin(), 0.5f, constraintAnchor24.f2463e, constraintAnchor25.f2463e, constraintAnchor24.getMargin(), 5);
                                                if (constraintAnchor2 != null && constraintWidget3 != constraintWidget2) {
                                                    linearSystem.addEquality(constraintAnchor3.f2463e, constraintAnchor2.f2463e, -constraintAnchor3.getMargin(), i8);
                                                }
                                            }
                                        }
                                        i8 = 5;
                                        constraintAnchor2 = constraintAnchor25;
                                        constraintAnchor3 = constraintAnchor24;
                                        if (constraintAnchor2 != null) {
                                            linearSystem.addEquality(constraintAnchor3.f2463e, constraintAnchor2.f2463e, -constraintAnchor3.getMargin(), i8);
                                        }
                                    }
                                } else {
                                    ConstraintAnchor constraintAnchor26 = constraintWidget27.mListAnchors[i3];
                                    int i34 = i3 + 1;
                                    ConstraintAnchor constraintAnchor27 = constraintWidget22.mListAnchors[i34];
                                    ConstraintAnchor constraintAnchor28 = constraintAnchor26.mTarget;
                                    if (constraintAnchor28 != null) {
                                        solverVariable9 = constraintAnchor28.f2463e;
                                    } else {
                                        solverVariable9 = null;
                                    }
                                    ConstraintAnchor constraintAnchor29 = constraintAnchor27.mTarget;
                                    if (constraintAnchor29 != null) {
                                        solverVariable10 = constraintAnchor29.f2463e;
                                    } else {
                                        solverVariable10 = null;
                                    }
                                    ConstraintAnchor constraintAnchor30 = constraintWidget23.mListAnchors[i3];
                                    if (constraintWidget24 != null) {
                                        constraintAnchor27 = constraintWidget24.mListAnchors[i34];
                                    }
                                    if (solverVariable9 != null && solverVariable10 != null) {
                                        if (i19 == 0) {
                                            f = constraintWidget26.f2499x;
                                        } else {
                                            f = constraintWidget26.f2500y;
                                        }
                                        constraintWidget2 = constraintWidget24;
                                        SolverVariable solverVariable22 = solverVariable10;
                                        constraintWidget18 = constraintWidget22;
                                        constraintWidget3 = constraintWidget23;
                                        i6 = i4;
                                        linearSystem.addCentering(constraintAnchor30.f2463e, solverVariable9, constraintAnchor30.getMargin(), f, solverVariable22, constraintAnchor27.f2463e, constraintAnchor27.getMargin(), 7);
                                    } else {
                                        constraintWidget2 = constraintWidget24;
                                        constraintWidget3 = constraintWidget23;
                                        constraintWidget18 = constraintWidget22;
                                        i6 = i4;
                                    }
                                    constraintWidget4 = constraintWidget18;
                                }
                                if ((!z5 || z3) && constraintWidget3 != null && constraintWidget3 != constraintWidget2) {
                                    ConstraintAnchor[] constraintAnchorArr6 = constraintWidget3.mListAnchors;
                                    ConstraintAnchor constraintAnchor31 = constraintAnchorArr6[i3];
                                    if (constraintWidget2 == null) {
                                        constraintWidget17 = constraintWidget3;
                                    } else {
                                        constraintWidget17 = constraintWidget2;
                                    }
                                    int i35 = i3 + 1;
                                    ConstraintAnchor constraintAnchor32 = constraintWidget17.mListAnchors[i35];
                                    constraintAnchor7 = constraintAnchor31.mTarget;
                                    if (constraintAnchor7 != null) {
                                        solverVariable7 = constraintAnchor7.f2463e;
                                    } else {
                                        solverVariable7 = null;
                                    }
                                    constraintAnchor8 = constraintAnchor32.mTarget;
                                    if (constraintAnchor8 != null) {
                                        solverVariable8 = constraintAnchor8.f2463e;
                                    } else {
                                        solverVariable8 = null;
                                    }
                                    if (constraintWidget4 != constraintWidget17) {
                                        ConstraintAnchor constraintAnchor33 = constraintWidget4.mListAnchors[i35].mTarget;
                                        if (constraintAnchor33 != null) {
                                            solverVariable8 = constraintAnchor33.f2463e;
                                        }
                                        if (constraintWidget3 == constraintWidget17) {
                                            constraintAnchor32 = constraintAnchorArr6[i35];
                                        }
                                        if (solverVariable7 != null && solverVariable != null) {
                                            linearSystem.addCentering(constraintAnchor31.f2463e, solverVariable7, constraintAnchor31.getMargin(), 0.5f, solverVariable, constraintAnchor32.f2463e, constraintWidget17.mListAnchors[i35].getMargin(), 5);
                                        }
                                    }
                                    solverVariable = solverVariable8;
                                    if (constraintWidget3 == constraintWidget17) {
                                    }
                                    if (solverVariable7 != null) {
                                        linearSystem.addCentering(constraintAnchor31.f2463e, solverVariable7, constraintAnchor31.getMargin(), 0.5f, solverVariable, constraintAnchor32.f2463e, constraintWidget17.mListAnchors[i35].getMargin(), 5);
                                    }
                                }
                            }
                        }
                        if (z4) {
                            ConstraintAnchor constraintAnchor34 = constraintAnchor14.mTarget;
                            if (constraintAnchor34.mOwner == constraintWidgetContainer2) {
                                linearSystem.addEquality(constraintAnchor14.f2463e, constraintAnchor34.f2463e, -constraintAnchor14.getMargin(), 4);
                            }
                        }
                        linearSystem.addLowerThan(constraintAnchor14.f2463e, constraintWidget22.mListAnchors[i24].mTarget.f2463e, -constraintAnchor14.getMargin(), 6);
                        if (z) {
                        }
                        arrayList2 = chainHead3.mWeightedMatchConstraintsWidgets;
                        if (arrayList2 != null) {
                            if (chainHead3.mHasUndefinedWeights) {
                                f4 = chainHead3.mWidgetsMatchCount;
                            }
                            float f52 = RecyclerView.f7068F0;
                            float f62 = 0.0f;
                            ConstraintWidget constraintWidget282 = null;
                            i13 = 0;
                            while (i13 < size) {
                            }
                        }
                        if (constraintWidget23 != null) {
                        }
                        constraintWidget2 = constraintWidget24;
                        constraintWidget3 = constraintWidget23;
                        constraintWidget4 = constraintWidget22;
                        i6 = i4;
                        constraintWidget5 = constraintWidget27;
                        if (!z5) {
                        }
                        if (z3) {
                            i7 = chainHead3.mWidgetsMatchCount;
                            if (i7 <= 0) {
                            }
                            z6 = false;
                            constraintWidget6 = constraintWidget3;
                            ConstraintWidget constraintWidget332 = constraintWidget6;
                            while (constraintWidget6 != null) {
                            }
                            ConstraintAnchor constraintAnchor232 = constraintWidget3.mListAnchors[i3];
                            constraintAnchor = constraintWidget5.mListAnchors[i3].mTarget;
                            int i332 = i3 + 1;
                            ConstraintAnchor constraintAnchor242 = constraintWidget2.mListAnchors[i332];
                            ConstraintAnchor constraintAnchor252 = constraintWidget4.mListAnchors[i332].mTarget;
                            if (constraintAnchor != null) {
                            }
                            i8 = 5;
                            constraintAnchor2 = constraintAnchor252;
                            constraintAnchor3 = constraintAnchor242;
                            if (constraintAnchor2 != null) {
                            }
                        }
                        if (!z5) {
                        }
                        ConstraintAnchor[] constraintAnchorArr62 = constraintWidget3.mListAnchors;
                        ConstraintAnchor constraintAnchor312 = constraintAnchorArr62[i3];
                        if (constraintWidget2 == null) {
                        }
                        int i352 = i3 + 1;
                        ConstraintAnchor constraintAnchor322 = constraintWidget17.mListAnchors[i352];
                        constraintAnchor7 = constraintAnchor312.mTarget;
                        if (constraintAnchor7 != null) {
                        }
                        constraintAnchor8 = constraintAnchor322.mTarget;
                        if (constraintAnchor8 != null) {
                        }
                        if (constraintWidget4 != constraintWidget17) {
                        }
                        solverVariable = solverVariable8;
                        if (constraintWidget3 == constraintWidget17) {
                        }
                        if (solverVariable7 != null) {
                        }
                    }
                }
                if (z) {
                }
                arrayList2 = chainHead3.mWeightedMatchConstraintsWidgets;
                if (arrayList2 != null) {
                }
                if (constraintWidget23 != null) {
                }
                constraintWidget2 = constraintWidget24;
                constraintWidget3 = constraintWidget23;
                constraintWidget4 = constraintWidget22;
                i6 = i4;
                constraintWidget5 = constraintWidget27;
                if (!z5) {
                }
                if (z3) {
                }
                if (!z5) {
                }
                ConstraintAnchor[] constraintAnchorArr622 = constraintWidget3.mListAnchors;
                ConstraintAnchor constraintAnchor3122 = constraintAnchorArr622[i3];
                if (constraintWidget2 == null) {
                }
                int i3522 = i3 + 1;
                ConstraintAnchor constraintAnchor3222 = constraintWidget17.mListAnchors[i3522];
                constraintAnchor7 = constraintAnchor3122.mTarget;
                if (constraintAnchor7 != null) {
                }
                constraintAnchor8 = constraintAnchor3222.mTarget;
                if (constraintAnchor8 != null) {
                }
                if (constraintWidget4 != constraintWidget17) {
                }
                solverVariable = solverVariable8;
                if (constraintWidget3 == constraintWidget17) {
                }
                if (solverVariable7 != null) {
                }
            }
            i20 = i6 + 1;
            constraintWidgetContainer2 = constraintWidgetContainer;
            arrayList4 = arrayList;
            i19 = i;
            i2 = i5;
        }
    }
}
