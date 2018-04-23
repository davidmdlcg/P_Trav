# coding: utf-8

require 'capybara'
require 'capybara/cucumber'
require 'capybara/poltergeist'
require 'capybara/rspec'
require 'rspec'
require 'nokogiri'

# Capybara
Capybara.app = 'http://www.yahoo.co.jp'
Capybara.app_host = 'http://www.yahoo.co.jp'
Capybara.run_server = false

# Poltergeist
Capybara.register_driver :poltergeist do |app|
  options = {
      debug: false,
      js_errors: false,
      inspector: true,
      timeout: 120,
      phantomjs_options: %w(--ignore-ssl-errors=yes --web-security=no)
  }

  Capybara::Poltergeist::Driver.new(app, options)
end

# Poltergeist
Capybara.default_driver = :poltergeist
Capybara.javascript_driver = :poltergeist
