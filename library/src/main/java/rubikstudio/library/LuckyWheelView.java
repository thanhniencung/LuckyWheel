package rubikstudio.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

import rubikstudio.library.model.LuckyItem;

/**
 * Created by kiennguyen on 11/5/16.
 */

public class LuckyWheelView extends RelativeLayout implements PielView.PieRotateListener {
    private int mBackgroundColor;
    private int mTextColor;
    private Drawable mCenterImage;
    private Drawable mCursorImage;

    private PielView pielView;
    private ImageView ivCursorView;

    private LuckyRoundItemSelectedListener mLuckyRoundItemSelectedListener;

    @Override
    public void rotateDone(int index) {
        if (mLuckyRoundItemSelectedListener != null) {
            mLuckyRoundItemSelectedListener.LuckyRoundItemSelected(index);
        }
    }

    public interface LuckyRoundItemSelectedListener {
        void LuckyRoundItemSelected(int index);
    }

    public void setLuckyRoundItemSelectedListener(LuckyRoundItemSelectedListener listener) {
        this.mLuckyRoundItemSelectedListener = listener;
    }

    public LuckyWheelView(Context context) {
        super(context);
        init(context, null);
    }

    public LuckyWheelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    /**
     *
     * @param ctx
     * @param attrs
     */
    private void init(Context ctx, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = ctx.obtainStyledAttributes(attrs, R.styleable.LuckyWheelView);
            mBackgroundColor = typedArray.getColor(R.styleable.LuckyWheelView_lkwBackgroundColor, 0xffcc0000);
            mTextColor = typedArray.getColor(R.styleable.LuckyWheelView_lkwTextColor, 0xffffffff);
            mCursorImage = typedArray.getDrawable(R.styleable.LuckyWheelView_lkwCursor);
            mCenterImage = typedArray.getDrawable(R.styleable.LuckyWheelView_lkwCenterImage);
            typedArray.recycle();
        }

        LayoutInflater inflater = LayoutInflater.from(getContext());
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.lucky_wheel_layout, this, false);

        pielView = (PielView) frameLayout.findViewById(R.id.pieView);
        ivCursorView = (ImageView) frameLayout.findViewById(R.id.cursorView);

        pielView.setPieRotateListener(this);
        pielView.setPieBackgroundColor(mBackgroundColor);
        pielView.setPieCenterImage(mCenterImage);
        pielView.setPieTextColor(mTextColor);

        ivCursorView.setImageDrawable(mCursorImage);

        addView(frameLayout);
    }

    public void setLuckyWheelBackgrouldColor(int color) {
        pielView.setPieBackgroundColor(color);
    }

    public void setLuckyWheelCursorImage(int drawable) {
        ivCursorView.setBackgroundResource(drawable);
    }

    public void setLuckyWheelCenterImage(Drawable drawable) {
        pielView.setPieCenterImage(drawable);
    }

    public void setLuckyWheelTextColor(int color) {
        pielView.setPieTextColor(color);
    }

    /**
     *
     * @param data
     */
    public void setData(List<LuckyItem> data) {
        pielView.setData(data);
    }

    /**
     *
     * @param numberOfRound
     */
    public void setRound(int numberOfRound) {
        pielView.setRound(numberOfRound);
    }

    public void startLuckyWheelWithTargetIndex(int index) {
        pielView.rotateTo(index);
    }
}
