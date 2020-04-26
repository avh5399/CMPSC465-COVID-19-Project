clc

img = imread('brooklyn.png');
virus_spread = zeros(600,600);

% change values [0<x< 600, 0<y< 600]
y_cord = 400;
x_cord = 100;


%displays corrdinate on map
val = 50;
fprintf("%d %d %d %d \n", x_cord, y_cord, val);
virus_spread(x_cord, y_cord) = val;
gaussian_filter = fspecial('gaussian', [100,100], 20);
density = imfilter(virus_spread, gaussian_filter, 'replicate');
omask = heatmap_overlay(img, density, 'jet');
imshow(omask, []);


