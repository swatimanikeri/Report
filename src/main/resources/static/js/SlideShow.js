/*** Slideshow Options ****/

/* Sliding Speed 
 * Changes the rate at which the images slide. Bigger number means slower
 */
var slideSpeed = 600;

/* Automatic Sliding
 * Sets whether or not the slides scroll automatically. Set to false to turn off.
 */
var autoSlide = true;

/* Automatic Sliding Timer
 * Sets how much time between each automatic slide.  Number is milliseconds (5000 = 5 secs).
 */
var autoSlideTimer = 5000;

/* Random Image
 * Sets whether or not a random image will be chosen when the page loads. If false, the first image will show.
 */
var loadRandom = true;

/* This code is executed after the DOM has been completely loaded */
$(document).ready(function() {

    var totWidth = 0;
    var positions = [];

    /* Loop through all the slides and store their accumulative widths in totWidth */
    $('.slides .slide').each(function(i) {
        /* The positions array contains each slide's cumulative offset from the left part of the container */
        positions[i] = totWidth;
        totWidth += $(this).outerWidth(); // Use outerWidth() to account for margin/padding if present

        /* Notify if there is no width defined in HTML */
        if (!$(this).outerWidth()) {
            alert("Please, fill in width & height for all your images!");
            return false;
        }
    });

    /* Change the container div's width to the exact width of all the slides combined */
    $('.slides').width(totWidth);

    /* Set a random image as the first one. will change each time the page loads */
    if (loadRandom) {
        var firstImg = Math.floor(Math.random() * positions.length);
        $('.slides div:nth-child(' + (firstImg + 1) + ')').addClass('active');
        $('.slides').css({
            marginLeft: -positions[firstImg] + 'px'
        });
    }

    if (autoSlide) {
        function startTimer() {
            nextSlide();
            var timer = setTimeout(startTimer, autoSlideTimer);
        }
        startTimer();
    }

    $('#menu a.next').click(function(e) {
        /* Prevent the default action of the link */
        e.preventDefault();
        nextSlide();
    });

    /* Set up the previous button actions */
    $('#menu a.previous').click(function(e) {
        /* Prevent the default action of the link */
        e.preventDefault();
        previousSlide();
    });

    function previousSlide() {
        /* Find which image we're on and remove the active class */
        var pos = $('.active').prevAll().length;
        $('.active').removeClass('active');

        if (pos == 0) { /* We're on the first slide, so need to loop */
            $('.slides').stop().animate({
                marginLeft: -positions[positions.length - 1] + 'px'
            }, slideSpeed);
            $('.slides div:nth-child(' + positions.length + ')').addClass('active');
        } else {
            $('.slides').stop().animate({
                marginLeft: -positions[pos - 1] + 'px'
            }, slideSpeed);
            $('.slides div:nth-child(' + pos + ')').addClass('active');
        }
    }

    function nextSlide() {
        /* Find which image we're on and remove the active class */
        var pos = $('.active').prevAll().length;
        $('.active').removeClass('active');

        if (pos == positions.length - 1) { /* We're on the last slide, so need to loop */
            $('.slides').stop().animate({
                marginLeft: -positions[0] + 'px'
            }, slideSpeed);
            $('.slides div:nth-child(1)').addClass('active');
        } else {
            $('.slides').stop().animate({
                marginLeft: -positions[pos + 1] + 'px'
            }, slideSpeed);
            $('.slides div:nth-child(' + (pos + 2) + ')').addClass('active');
        }
    }

});
