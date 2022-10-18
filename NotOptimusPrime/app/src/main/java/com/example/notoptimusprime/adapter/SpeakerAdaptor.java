package com.example.notoptimusprime.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.notoptimusprime.R;
import com.example.notoptimusprime.model.Speaker;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SpeakerAdaptor extends ArrayAdapter<Speaker> {
    int mLayoutID;
    List<Speaker> mSpeakers;
    Context mContext;
    MediaPlayer mediaPlayer;

    public SpeakerAdaptor(@NonNull Context context,int resource, @NonNull List<Speaker> objects){
        super(context, resource, objects);
        mLayoutID = resource;
        mContext = context;
        mSpeakers = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent){
        //Get a reference to the current ListView item
        View currentListViewItem = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        if (currentListViewItem == null) {
            currentListViewItem = LayoutInflater.from(getContext()).inflate(mLayoutID, parent, false);
        }

        //Get the Number object for the current position
        Speaker currentSpeaker = mSpeakers.get(position);

        //Set the attributed of list_view_number_item_views
        ImageView iconImageView = (ImageView) currentListViewItem.findViewById(R.id.icon_image_view);
        int i = mContext.getResources().getIdentifier(
                currentSpeaker.getIconFilename(), "drawable", mContext.getPackageName());

        //Setting the icon
        iconImageView.setImageResource(i);

        TextView maoriTextView = (TextView) currentListViewItem.findViewById(R.id.speaker_text);
        maoriTextView.setText(currentSpeaker.getSpeakerName());

        TextView intelligibilityTextView = (TextView) currentListViewItem.findViewById(R.id.speaker_intelligibility);
        intelligibilityTextView.setText(currentSpeaker.getIntelligibility());
        TextView commandTextView = (TextView) currentListViewItem.findViewById(R.id.speaker_command);
        commandTextView.setText(currentSpeaker.getCommand());

        //Getting audio resource id for current Number object
        final String audio = currentSpeaker.getAudioFilename();
        final ImageView play = (ImageView) currentListViewItem.findViewById(R.id.play_button);


        //Setting the image click handler
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Operations to perform when the play ImageView is clicked
                int i = mContext.getResources().getIdentifier(
                        audio, "raw",
                        mContext.getPackageName());
                //Using MediaPlayer to play the audio file
                if (mediaPlayer != null)
                    mediaPlayer.release();
                mediaPlayer = MediaPlayer.create(mContext, i);
                mediaPlayer.start();
            }
        });

        //Getting audio resource id for the current Number object
        return currentListViewItem;
    }
}


