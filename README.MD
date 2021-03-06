# Project 1 - Flicks

Flicks shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: 20  hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **scroll through current movies** from the Movie Database API
* [x] Layout is optimized with the [ViewHolder](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView#improving-performance-with-the-viewholder-pattern) pattern.
* [x] For each movie displayed, user can see the following details:
* [x] Title, Poster Image, Overview (Portrait mode)
* [x] Title, Backdrop Image, Overview (Landscape mode)

The following **optional** features are implemented:

* [x] User can **pull-to-refresh** popular stream to get the latest movies.
* [x] Display a nice default [placeholder graphic](http://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library#configuring-picasso) for each image during loading.
* [x] Improved the user interface through styling and coloring.

The following **bonus** features are implemented:

* [x] Allow user to view details of the movie including ratings and popularity within a separate activity or dialog fragment.
* [x] When viewing a popular movie (i.e. a movie voted for more than 5 stars) the video should show the full backdrop image as the layout.  Uses [Heterogenous ListViews](http://guides.codepath.com/android/Implementing-a-Heterogenous-ListView) or [Heterogenous RecyclerView](http://guides.codepath.com/android/Heterogenous-Layouts-inside-RecyclerView) to show different layouts.
* [x] Allow video trailers to be played in full-screen using the YouTubePlayerView.
    * [x] Overlay a play icon for videos that can be played. **actually I display YouTube video preview which overlays the icon that can be clicked to play**
    * [x] More popular movies should start a separate activity that plays the video immediately. **when you click details of a movie, for movies with rating 2.5 stars on my UI (5 in the Movie DB interface), the video autoplay in a new activity. For movies with less stars I show YouTube preview with no autoplay.**
    * [x] Less popular videos rely on the detail page should show ratings and a YouTube preview.
* [x] Apply the popular [Butterknife annotation library](http://guides.codepath.com/android/Reducing-View-Boilerplate-with-Butterknife) to reduce boilerplate code.
* [x] Apply rounded corners for the poster or background images using [Picasso transformations](https://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library#other-transformations)
* [ ] Replaced android-async-http network client with the popular [OkHttp](http://guides.codepath.com/android/Using-OkHttp) or [Volley](http://guides.codepath.com/android/Networking-with-the-Volley-Library) networking libraries.

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories: 
Here's a walkthrough of implemented user stories: <video width="320" height="240" controls>
                                                    <source src="https://www.dropbox.com/s/2bour2r2e3ciscv/flick_demo.mp4?raw=1" type="video/mp4">
                                                    Your browser does not support the video tag. Vidoe URL: https://www.dropbox.com/s/2bour2r2e3ciscv/flick_demo.mp4?raw=1
                                                  </video>

## Notes

Describe any challenges encountered while building the app.

**I could not play videos on the list. The reason is when I bind one Youtube player on the list row, the other ones stop playing / displaying content. It looks like there can be at most one Youtube player playing or even displaying preview at the same time.
<a href="https://www.dropbox.com/s/hp9023vd4q1geb3/youTube_and_recycleView.mp4?raw=1">I made a video to illustrate this problem</a>.**


## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
