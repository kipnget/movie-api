package com.example.movie.ui.detail;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.movie.ui.cast.CastFragment;
import com.example.movie.ui.info.InformationFragment;
import com.example.movie.ui.review.ReviewFragment;
import com.example.movie.ui.trailer.TrailerFragment;
import com.example.movie.utilities.Constant;

import static com.example.movie.utilities.Constant.CAST;
import static com.example.movie.utilities.Constant.INFORMATION;
import static com.example.movie.utilities.Constant.REVIEWS;
import static com.example.movie.utilities.Constant.TRAILERS;

/**
 * The DetailPagerAdapter provides the appropriate {@link Fragment} for a view pager.
 */
public class DetailPagerAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Creates a new {@link DetailPagerAdapter} object
     *
     * @param context The context of the app
     * @param fm The fragment manager that will keep each fragment's state in the adapter across swipes
     */
    public DetailPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case INFORMATION:
                return new InformationFragment();
            case TRAILERS:
                return new TrailerFragment();
            case CAST:
                return new CastFragment();
            case REVIEWS:
                return new ReviewFragment();
        }
        return null;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return Constant.PAGE_COUNT;
    }

    /**
     * Return a title string to describe the specified page.
     *
     * @param position The position of the title requested
     * @return A title of the requested page
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Constant.TAP_TITLE[position % Constant.PAGE_COUNT].toUpperCase();
    }
}
