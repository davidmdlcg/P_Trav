require 'selenium-webdriver'

driver = Selenium::WebDriver.for :firefox




Given(/^We navigate to youtube$/) do
  driver.navigate.to "http://youtube.com/"
end

When(/^We search for the word agile$/) do
  driver.find_element(:name, 'search_query').send_keys("agile")
  driver.find_element(:id, 'search-icon-legacy').click
end

Then(/^The results for the search will be displayed$/) do
  wait = Selenium::WebDriver::Wait.new(:timeout => 5) # seconds
  if driver.find_element(:id, 'video-title')
  	puts "Success"
  else
  	puts "Failed"
  end
end




Given(/^We navigate to Youtube$/) do
  driver.navigate.to "https://www.youtube.com/"
end

When(/^We search the Auron Play channel$/) do
  driver.find_element(:name, 'search_query').send_keys("AuronPlay")
  driver.find_element(:id, 'search-icon-legacy').click
end

Then(/^The channel will be contained a video of Next program$/) do
  wait = Selenium::WebDriver::Wait.new(:timeout => 5) # seconds
  if driver.find_element(:id, 'video-title')
  	puts "Success"
  else
  	puts "Failed"
  end
end




Given(/^We navigate to agiletrailblazers$/) do
  driver.navigate.to "http://mock.agiletrailblazers.com/"
  wait = Selenium::WebDriver::Wait.new(:timeout => 5) # seconds
end

When(/^We search agile word$/) do
  wait = Selenium::WebDriver::Wait.new(:timeout => 5) # seconds
  driver.find_element(:id, 's').send_keys("agilidad")
  driver.find_element(:id, 'submit-button').click
end

Then(/^The results for the agile search$/) do
  wait = Selenium::WebDriver::Wait.new(:timeout => 5) # seconds
  element = wait.until { driver.find_element(:id => "search-title") }
  if element.text.include? 'Search Results for: agilidad'
    puts "Success"
  else
    puts "Failed"
    driver.quit
  end
end




Given(/^We navigate to agiletrailblazerss$/) do
  driver.navigate.to "http://mock.agiletrailblazers.com/"
  wait = Selenium::WebDriver::Wait.new(:timeout => 5) # seconds
end

When(/^We search calidad software words$/) do
  wait = Selenium::WebDriver::Wait.new(:timeout => 5) # seconds
  driver.find_element(:id, 's').send_keys("calidad software")
  driver.find_element(:id, 'submit-button').click
end

Then(/^The results for the calidad software search$/) do
  wait = Selenium::WebDriver::Wait.new(:timeout => 5) # seconds
  element = wait.until { driver.find_element(:id => "search-title") }
  if element.text.include? 'Search Results for: calidad+software'
    puts "Success"
  else
    puts "Failed"
    driver.quit
  end
end




Given(/^We navigate to agiletrailblazersss$/) do
  driver.navigate.to "http://mock.agiletrailblazers.com/contact.html"
  wait = Selenium::WebDriver::Wait.new(:timeout => 10) # seconds
end

When(/^We contact with administrator in contact us$/) do
  wait = Selenium::WebDriver::Wait.new(:timeout => 5) # seconds
  driver.find_element(:id, 'name').send_keys("G7")
  driver.find_element(:id, 'email').send_keys("G7@G7.com")
  driver.find_element(:id, 'mobile').send_keys("7")
  driver.find_element(:id, 'office').send_keys("G7")
  driver.find_element(:id, 'message').send_keys("G7")
  driver.find_element(:id, 'submit').click
end

Then(/^Will be display success message$/) do
  wait = Selenium::WebDriver::Wait.new(:timeout => 5) # seconds
  if driver.find_element(:id, 'success-message')
    puts "Success"
    driver.quit
  else
    puts "Failed"
  end
  
end