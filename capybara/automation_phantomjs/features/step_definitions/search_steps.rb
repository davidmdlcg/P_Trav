require 'capybara/poltergeist'

Given(/^We navigate to youtube1$/) do
	visit('http://youtube.com/')
	puts page.title
end

When(/^We search for the word agile$/) do
	fill_in('masthead-search-term', with: 'agile')
	click_button('search-btn')
	puts page.title
end

Then(/^The first result for the search will be displayed1$/) do
	element = first('.yt-lockup-title a')
	puts element.text.strip
	#spage.find('#').should have_content('')
	if page.has_content?('What is Agile?')
		puts "Success"
	else
		puts "Failed"
	end
end



Given(/^We navigate to youtube2$/) do
	visit('http://youtube.com/')
	puts page.title
end

When(/^We search for the word cucumber$/) do
	fill_in('masthead-search-term', with: 'cucumber')
	click_button('search-btn')
	puts page.title
end

Then(/^The first result for the search will be displayed2$/) do
	element = first('.yt-lockup-title a')
	puts element.text.strip
	#spage.find('#').should have_content('')
	if page.has_content?('Cucumber by Macka B')
		puts "Success"
	else
		puts "Failed"
	end
end



Given(/^We navigate to agiletrailblazers$/) do
  visit "http://mock.agiletrailblazers.com/"
  sleep(5)
end

When(/^We search agile word$/) do
  sleep(5)
  #driver.find_element(:id, 's').send_keys("agilidad")
  fill_in('s', :with => 'agilidad')
  #driver.find_element(:id, 'submit-button').click
  find('input[id="submit-button"]').click
end

Then(/^The results for the agile search$/) do
  sleep(5)
  page.should have_content('Search Results for: agilidad')
end



Given(/^We navigate to agiletrailblazerss$/) do
  visit "http://mock.agiletrailblazers.com/contact.html"
  sleep(5)
end

When(/^We contact with administrator in contact us$/) do
  sleep(5)
  fill_in('name', with: 'G7')
  fill_in('email', with: 'G7@G7.com')
  fill_in('mobile', with: 'G7')
  fill_in('office', with: 'G7')
  fill_in('message', with: 'G7')
  find('input[id="submit"]').click
end

Then(/^Will be display success message$/) do
  sleep(5)
  if page.has_content?('Your message was sent successfully. Thanks.')
    puts "Success"
  else
    puts "Failed"
  end
  
end



Given(/^We navigate to youtube3$/) do
	visit('http://youtube.com/')
	puts page.title
end

When(/^We search for the word software$/) do
	fill_in('masthead-search-term', with: 'software')
	click_button('search-btn')
	puts page.title
end

Then(/^The first result for the search will be displayed3$/) do
	element = first('.yt-lockup-title a')
	puts element.text.strip
	#spage.find('#').should have_content('')
	if page.has_content?('El software concepto y tipos')
		puts "Success"
	else
		puts "Failed"
	end
end


Given(/^We navigate to Spring boot youtube page$/) do
	visit 'https://www.youtube.com/watch?v=mN_9sKco_DQ'
end

When(/^Wait ten seconds, search and click$/) do
	sleep(10)
	fill_in('masthead-search-term', with: 'software')
	click_button('search-btn')
end

And(/^The result have content a specified info$/) do
	if page.has_content?('QUE ES EL SOFTWARE')
		puts "Success"
	else
		puts "Failed"
	end
	page.should have_content('20 Minutos de un Ingeniero de Software')
end