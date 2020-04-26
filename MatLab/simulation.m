clc

img = imread('brooklyn.png');
virus_spread = zeros(600,600);
data = readmatrix('data.xlsx','Range','B2:D829');
disp(data)

for i = 1:828
    x_cord = data(i, 1);
    y_cord = data(i, 2);
    val = data(i, 3);
    virus_spread(x_cord, y_cord) = val;
    gaussian_filter = fspecial('gaussian', [100,100], 25);
    density = imfilter(virus_spread, gaussian_filter, 'replicate');
  
    overlay = heatmap_overlay(img, density, 'jet');
    imshow(overlay, []);
end

colormap(jet);     
colorbar;
